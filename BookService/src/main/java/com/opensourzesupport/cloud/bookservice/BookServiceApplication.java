package com.opensourzesupport.cloud.bookservice;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.opensourzesupport.cloud.bookservice.models.Book;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/books")
//@RefreshScope
//@EnableFeignClients
public class BookServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceApplication.class);

	@Value("${eureka.instance.instance-id}")
	private String instanceId;
//	@Autowired
//	private StoreClient storeClient;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Value("${message:Hello default}")
	private String message;

	@RefreshScope
	@RequestMapping("/message")
	String getMessage() {
		LOGGER.info("message " + this.message);
		return this.message + " Server [ " + instanceId + "]";
	}

	private List<Book> bookList = Arrays.asList(new Book(1L, "FirstBook", "prasobh Kollattu"),
			new Book(2L, "SecondBook", "Prasobh KollattuO"));

	@GetMapping("")
	public List<Book> findAllBooks() {
		LOGGER.warn("books inoved");
		return bookList;
	}

	@GetMapping("/{bookId}")
	public Book findBook(@PathVariable Long bookId) {
		Book book = bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
		if (book == null) {
			book = getFromStore();
		}

		return book;
	}

//	@FeignClient(name = "StoreClient", url = "10.1.5.24:8089")
//	interface StoreClient {
//		@RequestMapping(method = RequestMethod.GET, value = "/stores/book", consumes = "application/json")
//		Book getBook();
//	}

	private Book getFromStore() {

		return this.restTemplate.getForObject("http://store-service/stores/book", Book.class);
		// Feign Impl
		// return storeClient.getBook();
	}
}
