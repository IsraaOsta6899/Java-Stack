package com.example.productsandcategories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.srevices.CategoryService;
@Controller
public class CategoryController {
	private final CategoryService categoryService;
	public CategoryController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	@GetMapping("/categories/new")
	public String String (@ModelAttribute ("category") Category category) {
		return "newCatrgory.jsp";
	}
	@PostMapping("/categories/new")
	public String createProduct(@ModelAttribute("category") Category category) {
		categoryService.createCategory(category);
		return "redirect:/categories/new";
	}
}
