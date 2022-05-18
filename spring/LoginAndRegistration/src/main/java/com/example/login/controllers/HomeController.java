package com.example.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.login.models.LoginUser;
import com.example.login.models.User;
import com.example.login.service.UserService;

//.. don't forget to inlcude all your imports! ..

@Controller
public class HomeController {
	private static UserService userService;
	public HomeController(UserService userService) {
		this.userService=userService;
	}
 // Add once service is implemented:
 // @Autowired
 // private UserService userServ;
 
 @GetMapping("/")
 public String index(Model model ) {
	 
     // Bind empty User and LoginUser objects to the JSP
	 User newUser = new User();
	 LoginUser newLogin= new LoginUser();
     // to capture the form input
     model.addAttribute("newUser", newUser);
     model.addAttribute("newLogin",newLogin);
     return "index.jsp";
 }

 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {
     
     // TO-DO Later -- call a register method in the service 
	 this.userService.register(newUser, result);
     // to do some extra validations and create a new user!
     
     if(result.hasErrors()) {
         // Be sure to send in the empty LoginUser before 
         // re-rendering the page.
         model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
     
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
 
     return "redirect:/";
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
     // Add once service is implemented:
      User user = this.userService.login(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "index.jsp";
     }
     System.out.println(user.getEmail()+"bbbbbbbbbbbbbbbbbbbbbbbbb");
 
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("user", user);
     return "redirect:/home";
 }
 @GetMapping("/home")
 public String home( HttpSession session, Model model) {
	 User user= new User();
	 user=(User) session.getAttribute("user");
     System.out.println(user.getEmail()+"ggggggggggggggggggggggggggggggggggggggguuuuuuuuuuuuuuuuuuuuuu");

	 return "Home.jsp";
 }
 
}

