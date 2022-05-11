package com.example.RenderingBooks.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RenderingBooks.models.Book;
import com.example.RenderingBooks.services.BookService;

@RestController
public class myController {
 private final BookService bookService;
 public myController(BookService bookService){
     this.bookService = bookService;
 }
 // other methods removed for brevity
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
 public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
     Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
     return book;
 }
 
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
 }
}
