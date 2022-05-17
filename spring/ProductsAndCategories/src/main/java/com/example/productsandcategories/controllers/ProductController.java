package com.example.productsandcategories.controllers;

import java.util.List;

import org.aspectj.apache.bcel.generic.LineNumberGen;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.srevices.CategoryService;
import com.example.productsandcategories.srevices.ProductService;
@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController(ProductService productService,CategoryService categoryService) {
		this.productService=productService;
		this.categoryService=categoryService;
	}
	@GetMapping("/products/new")
	public String String (@ModelAttribute ("product") Product product) {
		System.out.print("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		return "newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@ModelAttribute("product") Product product) {
		productService.createProduct(product);
		return "redirect:/products/new";
	}
	@GetMapping("/products/{id}")
	public String viewProduct(@PathVariable("id")Long id,Model model) {
		Product product= productService.findProduct(id);
		model.addAttribute("product", product);
		List<Category> BelongCategories= this.categoryService.findAllCategoriesBelongToThisProduct(product);
		model.addAttribute("BelongCategories", BelongCategories);
		for (Category category : BelongCategories) {
			System.out.println(category.getName());
		}
		System.out.println("////////////////");
		List<Category> notBelongCategories=this.categoryService.findAllCategoriesNotBelongToThisProduct(product);
		for (Category category : notBelongCategories) {
			System.out.println(category.getName());
		}
		System.out.println("=======================");
		model.addAttribute("notBelongCategories", notBelongCategories);

		return "product.jsp";
	}
	@PostMapping("/products/addCategory/{id}")
	public String addCategory(@RequestParam("c") Long c ,@PathVariable("id")Long id) {
		Product product= productService.findProduct(id);
		List<Category>categories=product.getCategories();
		Category category= this.categoryService.findCategory(c);
		categories.add(category);
		product.setCategories(categories);
		productService.updateProduct(product);
		
		return"redirect:/";
	}
//	@RequestParam("title") String title,
}
