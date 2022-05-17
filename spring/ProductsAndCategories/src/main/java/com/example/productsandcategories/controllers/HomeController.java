package com.example.productsandcategories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.srevices.CategoryService;
import com.example.productsandcategories.srevices.ProductService;
@Controller
public class HomeController {
	private final CategoryService categoryService;
	private final ProductService productService;

	public HomeController(CategoryService categoryService,ProductService productService) {
		this.categoryService=categoryService;
		this.productService=productService;
	}
	@GetMapping("/")
	public String showMainPage(Model model) {
		System.out.print("kkkkkkkkkkkkkkkkkkkkkkk");
		
		List<Category> categories=categoryService.getAllCategories();
		for (Category category : categories) {
			
			System.out.println(category.getName());
		}
		System.out.print("kkkkkkkkkkkkkkkkkkkkkkk");

		List<Product>products=productService.getAllCategories();
		for (Product product : products) {
			System.out.println(product.getName());
		}
		System.out.print("kkkkkkkkkkkkkkkkkkkkkkk");

		model.addAttribute("products", products);
		System.out.print("kkkkkkkkkkkkkkkkkkkkkkk");

		model.addAttribute("categories", categories);
		System.out.print("kkkkkkkkkkkkkkkkkkkkkkk");

		return "HomPage.jsp";
	}
	
}
