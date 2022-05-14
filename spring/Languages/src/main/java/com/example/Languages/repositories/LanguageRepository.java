package com.example.Languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Languages.models.Language;
@Repository
public interface LanguageRepository extends CrudRepository<Language,Long> {
	public List<Language>findAll();
	
}
