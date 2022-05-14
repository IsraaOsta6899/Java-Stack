package com.example.SaveTravels.services;

import java.util.List;
import java.util.Optional;
import com.example.SaveTravels.repository.travelsRepositories;
import com.example.SaveTravels.models.Travel;
import org.springframework.stereotype.Service;

@Service
public class travelsService {
 private final travelsRepositories travelsRepository;
	 
	 public travelsService(travelsRepositories travelRepository) {
	     this.travelsRepository = travelRepository;
	 }
	 // returns all the travels
	 public List<Travel> allTravels() {
	     return travelsRepository.findAll();
	 }
	 // creates a travel
	 public Travel createTravels(Travel b) {
	     return travelsRepository.save(b);

	 }
	 public Travel findTravels(Long id) {
	     Optional<Travel> t = travelsRepository.findById(id);
	     if(t.isPresent()) {
	         return t.get();
	     } else {
	         return null;
	     }
	 }
	 public Travel updateTeravel(Travel t){ 
	     Optional<Travel> t1 = travelsRepository.findById(t.getId());
	     Travel tt= t1.get();
		 tt.setDescription(t.getDescription());
		 tt.setAmount(t.getAmount());
		 tt.setExpense(t.getExpense());
		 tt.setVendor(t.getVendor());
		 return tt;
		
	 }
	
	 public void deleteTravel(Long id) {
		 travelsRepository.deleteById(id);
	 }
}
