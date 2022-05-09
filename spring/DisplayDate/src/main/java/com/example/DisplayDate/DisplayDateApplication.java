package com.example.DisplayDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@SpringBootApplication
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	 @Controller
	 public class FruitController {
   @RequestMapping("/")
   public String index(Model model) {

       return "Main.jsp";
   	}
   @RequestMapping("/date")
   public String time(Model model) {
	   Date date= new Date();
	   model.addAttribute("date",date);
       return "Date.jsp";
   	}
   @RequestMapping("/time")
   public String date(Model model) {
	   DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
       String time = formatter.format(new Date());
	   model.addAttribute("time",time);

       return "Time.jsp";
   	}
	 }
}
