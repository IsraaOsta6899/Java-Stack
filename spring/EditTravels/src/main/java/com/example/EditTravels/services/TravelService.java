package com.example.EditTravels.services;
import java.util.List;
import java.util.Optional;

import com.example.EditTravels.Repositories.*;
import com.example.EditTravels.models.*;
import com.example.EditTravels.models.Travel;
import com.example.EditTravels.Repositories.TravelRepository;

import org.springframework.stereotype.Service;
@Service
public class TravelService {
	private final TravelRepository travelsRepository;
	 
	 public TravelService(TravelRepository travelRepository) {
	     this.travelsRepository = travelRepository;
	 }
	 // returns all the travels
	 public List<Travel> allTravels() {

	     return (List<Travel>) travelsRepository.findAll();
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
