package com.example.SaveTravels.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.SaveTravels.models.Travel;
@Repository
public interface travelsRepositories extends CrudRepository<Travel, Long>{
    // this method retrieves all the books from the database
    List<Travel> findAll();
    // this method finds books with descriptions containing the search string
    List<Travel> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    
}