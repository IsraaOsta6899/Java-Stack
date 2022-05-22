package com.example.countries.repositiries;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.countries.models.*;

public interface CityRepo  extends CrudRepository<City, Long>{
	@Query("SELECT co.name, COUNT(c) FROM City c JOIN c.country co  GROUP BY co order by COUNT(c) asc ")
	List<Object[]> countOfCitiesInCountry();
	@Query("SELECT c.name FROM City c JOIN c.country co  WHERE co.name='Mexico' AND c.population > 500000 ")
	List<Object[]> findAllCitiesInMaxicoWhithSpecificPopulation();
	
	@Query("SELECT c.name,c.district,c.population,co.name FROM City c JOIN c.country co  WHERE c.population > 500000 and co.name='Argentina' and c.district='Buenos Aires'")
	List<Object[]> findAllCitiesInArgintinaWithConditions();

}
