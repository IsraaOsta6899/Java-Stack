package com.example.Books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan (basePackages={"com.example.Books.controllers","com.example.Books.services.BookService"})


public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);

	}

}
