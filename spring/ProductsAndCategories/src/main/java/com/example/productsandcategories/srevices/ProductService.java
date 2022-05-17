package com.example.productsandcategories.srevices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.repositories.ProductRepository;
@Service
public class ProductService {
	private final ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;	
	}
	public List<Product> getAllCategories(){
		return productRepository.findAll();
	}
	public Product createProduct(Product product) {
		this.productRepository.save(product);
		return product;
	}
	public Product findProduct(Long id) {
		Optional<Product> product= this.productRepository.findById(id);
		return product.get();
	}
	
	public Product updateProduct(Product p) {
		return this.productRepository.save(p);
	}
}
