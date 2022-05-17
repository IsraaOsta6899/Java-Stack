package com.example.DojoAndNinjas.servises;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.DojoAndNinjas.models.Ninja;
import com.example.DojoAndNinjas.repositories.NinjaRepository;
@Repository
public class NinjaSrevice {
	private final NinjaRepository ninjaRepository;
	public NinjaSrevice(NinjaRepository ninjaRepository) {
		this.ninjaRepository=ninjaRepository;
	}
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	public Ninja createNinja(Ninja ninja) {
		System.out.print("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

		System.out.print(ninja.getDojo().getName());
		System.out.print("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		ninjaRepository.save(ninja);
		return ninja;
	}
	
}
