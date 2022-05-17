package com.example.DojoAndNinjas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DojoAndNinjas.models.Dojo;
import com.example.DojoAndNinjas.models.Ninja;
import com.example.DojoAndNinjas.servises.*;


@Controller
public class NinjaController {
	private final NinjaSrevice ninjaSrevice;
	private final DojoServise dojoServise;
	public NinjaController(NinjaSrevice ninjaSrevice, DojoServise dojoServise) {
		this.ninjaSrevice=ninjaSrevice;
		this.dojoServise=dojoServise;
	}
	@GetMapping("/ninjas/new")
	public String createDogo(@ModelAttribute ("ninja") Ninja ninja,Model model ) {
		List<Dojo> allDojos=dojoServise.allDojos();
		model.addAttribute("dojos", allDojos);
		return "addNinja.jsp";
	}
	
	
	@PostMapping("/ninjas/new")
	public String addNinja(@ModelAttribute ("ninja") Ninja ninja,Model model) {
		List<Dojo> allDojos=dojoServise.allDojos();
		model.addAttribute("dojos", allDojos);
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkk");
		System.out.println(ninja.getAge());
		System.out.println("kkkkkkkkkkkkkkkkkkkkk2222222222222kk");

		System.out.println(ninja.getDojo().getName());
		
		

		this.ninjaSrevice.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	

}
