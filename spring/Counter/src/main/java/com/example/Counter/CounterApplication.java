package com.example.Counter;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	 @Controller
	 public class CounterController {
   @RequestMapping("/")
   		public String index(HttpSession session) {
		
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);	
			}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount=currentCount+1;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
//   Integer currentCount = (Integer) session.getAttribute("count");
   @RequestMapping("/counter")
		public String count(HttpSession session,Model model) {
	
	if (session.getAttribute("count") == null) {
		session.setAttribute("count", 0);	
		model.addAttribute("count",0);
		}
	else {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("count",currentCount);
	}
	return "counter.jsp";
}
   
   }

}
