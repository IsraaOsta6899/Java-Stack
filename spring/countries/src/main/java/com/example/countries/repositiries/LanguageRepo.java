package com.example.countries.repositiries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.countries.models.*;

public interface LanguageRepo  extends CrudRepository<Language, Long>{
	@Query("SELECT c.name, l.language,l.percentage FROM Language l JOIN l.country c WHERE l.percentage > 89 ORDER BY l.percentage desc")
	List<Object[]> findMostPopularLanguageInEachCountry();
	
}
