package com.example.countries.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.countries.services.ApiService;

@Controller
public class CountryController {
	
	private final ApiService apiService;
	public CountryController(ApiService apiService) {
		this.apiService=apiService;
	}
	
	@RequestMapping("/")
	public String index() {
		
		List<Object[]>objects=this.apiService.index2();
		for (Object[] objects2 : objects) {
			System.out.println(objects2[0]);
			System.out.println(objects2[1]);
			System.out.println(objects2[2]);

			System.out.println(objects2[3]);

			System.out.println("-----------------------------------------");

			

		}
		
		return "";
	}
}
