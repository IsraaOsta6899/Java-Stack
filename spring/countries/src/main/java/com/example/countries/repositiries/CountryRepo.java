package com.example.countries.repositiries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.countries.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long>{
	@Query("SELECT c.name, l.language,l.percentage FROM Country c JOIN c.languages l WHERE l.language='Slovene' ORDER BY l.percentage asc")
	List<Object[]> countriesSpeakSlovene();
	@Query("SELECT c.name FROM Country c WHERE c.surface_area > 501 AND c.population > 100000")
	List<Object[]> AllCountriesWithSpeseficSurface_areaAndPopulation();
	@Query("SELECT c.name FROM Country c WHERE c.government_form = 'Monarchy' AND c.surface_area > 200 And c.life_expectancy > 75")
	List<Object[]> AllCountriesWithCondition();
	@Query("SELECT co.region, COUNT(co) FROM Country co  GROUP BY co.region order by COUNT(co) asc ")
	List<Object[]>GroupingCountriesAccourdingToRegion();

	
}
