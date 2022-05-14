package com.example.Languages.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Languages.models.*;
import com.example.Languages.repositories.LanguageRepository;
@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository ) {
		this.languageRepository=languageRepository;
	}
	public List<Language> allLanguages() {

	     return (List<Language>) languageRepository.findAll();
	 }
	public Language createLanguage(Language l) {
	     return languageRepository.save(l);

	 }
	 public Language findLanguage(Long id) {
	     Optional<Language> t = languageRepository.findById(id);
	     if(t.isPresent()) {
	         return t.get();
	     } else {
	         return null;
	     }
	 }
	 public Language updateLanguage(Language l){ 
	     Optional<Language> l1 = languageRepository.findById(l.getId());
	     Language lang= l1.get();
	     lang.setCreator(l.getCreator());
	     lang.setName(l.getName());
	     lang.setVersion(l.getVersion());
	     languageRepository.save(l);
		 return lang;
		
	 }
	
	 public void deleteLanguage(Long id) {
		 languageRepository.deleteById(id);
	 }
}
