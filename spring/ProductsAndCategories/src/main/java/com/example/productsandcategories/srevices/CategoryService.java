package com.example.productsandcategories.srevices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.repositories.CategoryRepository;
@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;	
	}
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}

	public Category findCategory(Long id) {
		Optional<Category> category= this.categoryRepository.findById(id);
		return category.get()
				;
	}
	public List<Category>findAllCategoriesBelongToThisProduct(Product product){
		return this.categoryRepository.findAllByProducts(product);
	}
	public List<Category>findAllCategoriesNotBelongToThisProduct(Product product){
		return this.categoryRepository.findByProductsNotContains(product);
	}
}
