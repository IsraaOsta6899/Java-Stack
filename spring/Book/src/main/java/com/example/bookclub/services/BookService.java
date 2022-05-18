package com.example.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookclub.models.Book;
import com.example.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private static BookRepository bookRepository;
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	public Book findBook(Long id) {
		Optional<Book> book= bookRepository.findById(id);
		Book book2=book.get();
		return book2;
	}
}
