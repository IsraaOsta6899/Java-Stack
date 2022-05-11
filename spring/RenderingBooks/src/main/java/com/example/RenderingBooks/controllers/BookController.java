package com.example.RenderingBooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.RenderingBooks.models.Book;
import com.example.RenderingBooks.services.BookService;

@Controller
public class BookController {
 private final BookService bookService;
 public BookController(BookService bookService){
     this.bookService = bookService;
 }
 @RequestMapping(value="/")
 public String showw() {
	 System.out.print("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
     return "home.jsp";
 }
 // other methods removed for brevity
 @RequestMapping(value="/books/{id}")
 public String show(@PathVariable("id") Long id,Model model) {
	 System.out.print("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
     Book book = bookService.findBook(id);
     model.addAttribute("book",book);
     return "home.jsp";
 }
 
 
}