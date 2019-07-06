package com.opensourzesupport.cloud.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opensourzesupport.cloud.store.models.Book;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/stores")
/**
 * Store service.Ideally we should have a service class and dao class.But for
 * the sake of simplicity i have not used that deigin.We only have a single
 * controller
 * 
 * @author PRASOBH KOLLATTU
 *
 */
public class StoreServiceApplication {

	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	private static final Logger LOGGER = LoggerFactory.getLogger(StoreServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StoreServiceApplication.class, args);
	}

	@GetMapping("/book")
	public Book getBook() {
		LOGGER.info("book request received.");
		Book newBook = new Book(System.currentTimeMillis(), "New", "prasobh kollattu - " + instanceId);
		return newBook;
	}
}
