package com.example.Books.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Books.models.Book;
import com.example.Books.services.BookService;

@Controller
public class BookController {
 private final BookService bookService;
 public BookController(BookService bookService){
     this.bookService = bookService;
 }
 @RequestMapping(value="/")
 public String showw() {
     return "home.jsp";
 }
 // other methods removed for brevity
 @RequestMapping(value="/books/{id}")
 public String show(@PathVariable("id") Long id,Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book",book);
     return "book.jsp";
 }
 @PutMapping(value="/api/updateBook/{id}")
 public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	 Book b=new Book();
	 b.setDescription(desc);
	 b.setTitle(title);
	 b.setId(id);
	 b.setNumberOfPages(numOfPages);
	 b.setlanguage(lang);
	 Book book = bookService.updateBook( b);
     return book;
 }
 
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {

     bookService.deleteBook(id);
 }
 
 @PostMapping(value="/addBook")
 public void createBook(@RequestParam("title") String title,
		    @RequestParam("desc") String desc,
		    @RequestParam("lang") String lang,
		    @RequestParam("num") Integer num ) {
	 Book b = new Book();
     b.setDescription(desc);
     b.setlanguage(lang);
     b.setNumberOfPages(num);
     b.setDescription(desc);
	 b.setTitle(title);
	 bookService.createBook(b);
	 
 }
 @RequestMapping(value="/books")
 public String allBooks(Model model) {
	 List<Book>books=bookService.allBooks();
	 for(int i=0;i<books.size();i++) {
		 System.out.print(i+"llllllllllllllllllllllllllllooooooooooooooo");
	 }
	 model.addAttribute("books",books);
     return "home.jsp";
 }
 
 
}
