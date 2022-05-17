package com.example.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product>findAll();
	// Retrieves a list of all categories for a particular product



}
