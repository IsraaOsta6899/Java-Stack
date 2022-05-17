package com.example.DojoAndNinjas.servises;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.DojoAndNinjas.models.Dojo;
import com.example.DojoAndNinjas.models.Ninja;
import com.example.DojoAndNinjas.repositories.DojoRepository;
@Service
public class DojoServise {
	private final DojoRepository dojoRepository;
	public DojoServise(DojoRepository dojoRepository ) {
		this.dojoRepository=dojoRepository;
	}
	public List<Dojo> allBooks() {
		return dojoRepository.findAll();
	      
	 }
	
	public Dojo createDojo(Dojo d) {
		 dojoRepository.save(d);
		 return d;
	      
	 }
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	public List<Ninja> allNinjas(Long id){
		Optional<Dojo> dojo= dojoRepository.findById(id);
				Dojo myDojo=dojo.get();	
				return myDojo.getNinjas();
	}
}
