package com.example.mvc.services;

import java.util.List;
import java.util.Optional;

import com.example.mvc.models.*;
//...
import org.springframework.stereotype.Service;

import com.example.mvc.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Books> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Books createBook(Books b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Books findBook(Long id) {
     Optional<Books> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 public Books updateBook(Long id, String title,String desc, String lang,Integer numOfPages){
     Optional<Books> optionalBook = bookRepository.findById(id);
     Books b=optionalBook.get();
     b.setTitle(title);
     b.setDescription(desc);
     b.setNumberOfPages(numOfPages);
     b.setLanguage(lang);
     bookRepository.save(b);
	 return b;
	
 }
 public void deleteBook(Long id) {
	 bookRepository.deleteById(id);
 }
}


