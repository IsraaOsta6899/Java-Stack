package com.example.OmikujiForm;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class myController {
@RequestMapping(value="/omikuji")
public String index( ) {
	 System.out.print("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

   return "sendAnOmijkuji.jsp";
	}

@RequestMapping("/confirm")
public String display(@RequestParam(value="selectYear") String selectYear,
   	    @RequestParam(value="person") String person, @RequestParam(value="hoppy") String hoppy,
   	    @RequestParam(value="city") String city, @RequestParam(value="living") String living,HttpSession session) {
	 System.out.print("hhhhhhhhhhhhhhhoooooooooooooooooooooooooooohhh");
	    session.setAttribute("selectYear", selectYear);
   	session.setAttribute("person", person);
   	session.setAttribute("hoppy", hoppy);
   	session.setAttribute("city", city);
   	session.setAttribute("living", living);
   	return "redirect:/omikuji/show";
}
@RequestMapping("/omikuji/show")
public String show(Model model,HttpSession session) {
	 
	 	model.addAttribute("selectYear",session.getAttribute("selectYear") );	
	 	model.addAttribute("person",session.getAttribute("person") );
	 	model.addAttribute("hoppy",session.getAttribute("hoppy") );
	 	model.addAttribute("city",session.getAttribute("city") );
	 	model.addAttribute("living",session.getAttribute("living") );
	 	
   	return "Hello.jsp";
}
}