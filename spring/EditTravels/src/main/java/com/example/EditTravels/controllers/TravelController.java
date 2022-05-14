package com.example.EditTravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.EditTravels.models.Travel;
import com.example.EditTravels.services.TravelService;
@Controller
public class TravelController {
	private final TravelService travelService;
	 public TravelController(TravelService travelService){
	     this.travelService = travelService;
	 }



	 @PostMapping(value="/addTravels")
	 public String createBook(@Valid @ModelAttribute("travel") Travel travel, BindingResult result ) {
		if(result.hasErrors()) {
			return "index.jsp";
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
	 
	 @GetMapping(value="/expenses/edit/{id}")
	 public String openEditPage(@PathVariable("id") Long id,Model model) {
		 Travel travel= travelService.findTravels(id);
		 model.addAttribute("Travel",travel);
		 return "edit.jsp";
	 }
	


	 
	 
	 
}
