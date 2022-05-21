package com.example.bookclub.controllers;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.bookclub.models.Book;
import com.example.bookclub.models.LoginUser;
import com.example.bookclub.models.User;
import com.example.bookclub.services.BookService;
import com.example.bookclub.services.UserService;

//.. don't forget to inlcude all your imports! ..

@Controller
public class HomeController {
	private static UserService userService;
	private static BookService bookService;

	public HomeController(UserService userService,BookService bookService) {
		this.userService=userService;
		this.bookService=bookService;
	}

 
 @GetMapping("/")
 public String index(Model model ) {
	 
	 User newUser = new User();
	 LoginUser newLogin= new LoginUser();
     model.addAttribute("newUser", newUser);
     model.addAttribute("newLogin",newLogin);
     return "index.jsp";
 }

 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {

     if(result.hasErrors()) {

         model.addAttribute("newUser", newUser);

         model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
	 this.userService.register(newUser, result);

 
     return "redirect:/";
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
      User user = this.userService.login(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "index.jsp";
     }
 
     session.setAttribute("user", user);
     return "redirect:/home";
 }
 @GetMapping("/home")
 public String home( HttpSession session, Model model) {
	 User user= new User();
	 user=(User) session.getAttribute("user");
	 List<Book> books=this.bookService.getAllBooks();
	 model.addAttribute("books", books);
	 return "Home.jsp";
 }
 
 @GetMapping("/books/new")
 public String newBook( HttpSession session, Model model,@ModelAttribute("book")Book book) {
	 Book book2 = new Book();
	 model.addAttribute("book", book2);
	 return "newBook.jsp";
 }
 @GetMapping("/books/{id}")
 public String showBook( HttpSession session, Model model,@PathVariable("id")Long id) {
	 Book book2 = this.bookService.findBook(id);
	 model.addAttribute("book", book2);
	 User user= new User();
	 user=(User) session.getAttribute("user");
	 model.addAttribute("user", user);

	 return "showBook.jsp";
 }
 @PostMapping("/books/new")
 public String addBook( HttpSession session, Model model,@Valid@ModelAttribute("book")Book book,BindingResult result) {

	 if(!result.hasErrors()) {

	 Book newBook = book;
	 newBook.setBorrow(false);
	 User user= new User();
	 user=(User) session.getAttribute("user");
	 newBook.setUser(user);
	 model.addAttribute("book", newBook);
	 this.bookService.addBook(newBook);
	 return "redirect:/home";}
	 else {
		 Book book2=new Book();
		 model.addAttribute("book", book2);
	 return "newBook.jsp";
			 }
 }
 
 @RequestMapping("/books/editt/{id}")
 public String EditBage( HttpSession session, Model model,@PathVariable("id")Long id,@ModelAttribute("book")Book book) {
	 Book book2 = this.bookService.findBook(id);
	 model.addAttribute("book", book2);
	 User user= new User();
	 user=(User) session.getAttribute("user");
	 model.addAttribute("user", user);

	 return "EditBook.jsp";
 }
 
 @PostMapping("/books/edit/{id}")
 public String editBook( HttpSession session, Model model,@ModelAttribute("book")Book book) {

	 Book newBook = book;
	 User user= new User();
	 user=(User) session.getAttribute("user");
	 Book nn=bookService.findBook(book.getId());
	 User borrowUser = nn.getBorrowUser();
	 newBook.setBorrowUser(borrowUser);
	 newBook.setUser(user);
	 model.addAttribute("book", newBook);

	 this.bookService.addBook(newBook);

	 return "redirect:/home";
 }
 @GetMapping("/bookmarket")
 public String marketPage(Model model, HttpSession session) {

	 User user= new User();

	 user=(User) session.getAttribute("user");
	 model.addAttribute("user", user);

	 List<Book>barrowBooks=user.getBorrowBooks();
	 model.addAttribute("barrowBooks", barrowBooks);
	 for (Book book : barrowBooks) {
		System.out.println(book.getBookTitle()+"....................................");
	}

	 List<Book>availableBooks=bookService.getAvailabelBooks();
	 for (Book book : availableBooks) {
			System.out.println(book.getBookTitle()+"///////////////////////////////");

	}
	 model.addAttribute("availableBooks", availableBooks);

	 return "BookMarket.jsp";
 }
@RequestMapping("/borrows/{id}")
public String borrowBook(@PathVariable("id")Long id,HttpSession session) {
	User user= (User) session.getAttribute("user");
	Book book;
	book=bookService.findBook(id);

	book.setBorrow(true);

	book.setBorrowUser(user);

	Book book2=bookService.updateBook(book);

	user.getBorrowBooks().add(book2);

	userService.updateUser(user);	

	
	return "redirect:/bookmarket";
}
@RequestMapping("/release/{id}")
public String release(@PathVariable("id")Long id,HttpSession session) {
	Book book;
	book=bookService.findBook(id);
	book.setBorrow(false);
	book.setBorrowUser(null);
	Book book2=bookService.addBook(book);
	System.out.println("====================================");
	
	System.out.println(book2.getBorrow());
	

	User user= (User) session.getAttribute("user");
	List<Book>books=user.getBorrowBooks();

	for(int i=0;i<books.size();i++) {
	if(books.get(i).getBookTitle().equals(book.getBookTitle()))	{
		books.remove(i);
		System.out.println("yeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeessssssssssss!!!!!!!!!");
	}
}
	
user.setBorrowBooks(books)	;
	User user2=userService.updateUser(user);



	return "redirect:/bookmarket";

	
}

}

