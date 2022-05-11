package com.example.RenderingBooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan ({"com.example.RenderingBooks.services.BookService"})
public class RenderingBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenderingBooksApplication.class, args);
	}

}
