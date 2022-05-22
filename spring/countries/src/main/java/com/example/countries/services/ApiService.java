package com.example.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.countries.repositiries.CityRepo;
import com.example.countries.repositiries.CountryRepo;
import com.example.countries.repositiries.LanguageRepo;
@Service
public class ApiService {
	private final CityRepo cityRepo;	
	private final CountryRepo countryRepo;
	private final LanguageRepo languageRepo;

	public ApiService(CityRepo cityRepo,CountryRepo countryRepo,LanguageRepo languageRepo ) {
		this.cityRepo=cityRepo;
		this.countryRepo=countryRepo;
		this.languageRepo=languageRepo;
	}
	public List<Object[]>index1(){
		return cityRepo.countOfCitiesInCountry();
	}
	
	public List<Object[]>index2(){
		return cityRepo.findAllCitiesInArgintinaWithConditions();
	}
	
	public List<Object[]>index3(){
		return cityRepo.findAllCitiesInMaxicoWhithSpecificPopulation();
	}
	public List<Object[]>index4(){
		return languageRepo.findMostPopularLanguageInEachCountry();
	}
	
	public List<Object[]>index5(){
		return countryRepo.AllCountriesWithCondition();
	}
	
	public List<Object[]>index6(){
		return countryRepo.AllCountriesWithSpeseficSurface_areaAndPopulation();
	}
	
	
	public List<Object[]>index7(){
		return countryRepo.countriesSpeakSlovene();
	}
	
	public List<Object[]>index8(){
		return countryRepo.GroupingCountriesAccourdingToRegion();
	}
	

	
}
