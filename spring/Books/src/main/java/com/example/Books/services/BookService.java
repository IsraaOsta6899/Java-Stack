package com.example.Books.services;

import java.util.List;
import java.util.Optional;

import com.example.Books.Repositories.BookRepository;
import com.example.Books.models.Book;
import org.springframework.stereotype.Service;
@Service
public class BookService {
	 // adding the book repository as a dependency
	 private final BookRepository bookRepository;
	 
	 public BookService(BookRepository bookRepository) {
	     this.bookRepository = bookRepository;
	 }
	 // returns all the books
	 public List<Book> allBooks() {
	     return bookRepository.findAll();
	 }
	 // creates a book
	 public Book createBook(Book b) {
		 System.out.println(b.getTitle());
	     return bookRepository.save(b);

	 }
	 // retrieves a book
	 public Book findBook(Long id) {
	     Optional<Book> optionalBook = bookRepository.findById(id);
	     if(optionalBook.isPresent()) {
	         return optionalBook.get();
	     } else {
	         return null;
	     }
	 }
	 public Book updateBook(Book b){ 
	     Optional<Book> optionalBook = bookRepository.findById(b.getId());
		 Book bb= optionalBook.get();
		 bb.setDescription(b.getDescription());
		 bb.setlanguage(b.getLanguage());
		 bb.setNumberOfPages(b.getNumberOfPages());
		 bb.setTitle(b.getTitle());
		 bookRepository.save(bb);
		 return bb;
		
	 }
	
	 public void deleteBook(Long id) {
		 bookRepository.deleteById(id);
	 }
	}

