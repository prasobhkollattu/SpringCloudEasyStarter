package com.opensourzesupport.cloud.bookservice;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.opensourzesupport.cloud.bookservice.models.Book;

/**
 * Simple example to show how to write unit testing
 * 
 * @author PRASOBH KOLLATTU
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BookServiceApplication.class)
public class BookServiceApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void listOfBooks() throws Exception {

		Book book = new Book(1L, "FirstBook", "prasobh Kollattu");

		mvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].title", is(book.getTitle())));
	}

}
