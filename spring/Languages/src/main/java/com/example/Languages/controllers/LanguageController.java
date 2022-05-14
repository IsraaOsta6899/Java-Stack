package com.example.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Languages.models.Language;
import com.example.Languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	 public LanguageController(LanguageService languageService){
	     this.languageService = languageService;
	 }
	 @GetMapping(value="/languages")
	 public String allTravels(Model model,@ModelAttribute("language") Language language) {
		 List<Language>languages=languageService.allLanguages();
		 model.addAttribute("languages",languages);
	     return "Dashboard.jsp";
	 
	 }
	 @PostMapping(value="/languages")
	 public String create(Model model,@ModelAttribute("language") Language language, BindingResult result) {
		 if(result.hasErrors()) {
			 
			 return "Dashboard.jsp";
		 }
		 else { 
			 Language l=languageService.createLanguage(language);
		 
			 return "redirect:/languages";
	     }
	 
	 }
	 @GetMapping(value="/languages/delete/{id}")
	 public String deleteLanguage(@PathVariable("id")Long id) {
		 System.out.print("deeeeeeeeeeeeeeeeeeleeeeeeeeeettttttteeeeeeeeee");

		 languageService.deleteLanguage(id);
		 return "redirect:/languages";
	  }
	 @GetMapping(value="/languages/edit/{id}")
	 public String EditLanguage(@PathVariable("id")Long id,Model model) {
		 Language language= languageService.findLanguage(id);
		 model.addAttribute("language", language);
		 return "edit.jsp";
	  }
	 @RequestMapping("/langs/{id}")
	    public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
	        if (result.hasErrors()) {
	            return "Dashboard.jsp";
	        } else {
	        	languageService.updateLanguage(lang);
	            return "redirect:/languages";
	        }
	    }
	 @GetMapping(value="/language/{id}")
	 public String displayLanguage(@PathVariable("id")Long id,Model model) {
		 Language language= languageService.findLanguage(id);
		 model.addAttribute("language", language);
		 return "show.jsp";
	  }
	 
	 
}
