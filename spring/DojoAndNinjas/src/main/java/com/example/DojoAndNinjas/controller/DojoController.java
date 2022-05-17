package com.example.DojoAndNinjas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DojoAndNinjas.models.Dojo;
import com.example.DojoAndNinjas.models.Ninja;
import com.example.DojoAndNinjas.servises.DojoServise;

@Controller
public class DojoController {
	private final DojoServise dojoServise;
	public DojoController(DojoServise dojoServise) {
		this.dojoServise=dojoServise;
	}
	@GetMapping("/dojos/new")
	public String createDogo(@ModelAttribute ("dojo") Dojo dojo ) {
		
		return "addDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addDogo(@ModelAttribute ("dojo") Dojo dojo) {
		dojoServise.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/dojos/{id}")
	public String getAllNinjas(@PathVariable("id")Long id ,Model model) {
		List<Ninja> ninjas=dojoServise.allNinjas(id);
		for (Ninja ninja : ninjas) {
			System.out.println(ninja.getFirstName());
		}
		model.addAttribute("ns", ninjas);
		
		return "allNinjasBelongToDojo.jsp";
	}
	

}
