package com.example.SaveTravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SaveTravels.models.Travel;
import com.example.SaveTravels.services.travelsService;

@Controller
public class TravelController {
 private final travelsService travelService;
 public TravelController(travelsService travelService){
     this.travelService = travelService;
 }



 @PostMapping(value="/addTravels")
 public String createBook(@Valid @ModelAttribute("travel") Travel travel, BindingResult result ) {
	if(result.hasErrors()) {
		return "home.jsp";
	}else {
		travelService.createTravels(travel);
	     return "redirect:/expenses";
	}
     
	 
 }
 @GetMapping(value="/expenses")
 public String allTravels(Model model,@ModelAttribute("travel") Travel travel) {
	 List<Travel>travels=travelService.allTravels();
	 model.addAttribute("travels",travels);
     return "index.jsp";
 }
 
 
}
