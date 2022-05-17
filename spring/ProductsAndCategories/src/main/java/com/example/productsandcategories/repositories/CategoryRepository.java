package com.example.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	public List<Category>findAll();
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);
}
