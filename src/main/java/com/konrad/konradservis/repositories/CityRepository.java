package com.konrad.konradservis.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.konrad.konradservis.models.City;

@Transactional
public interface CityRepository extends CrudRepository<City, Integer>  {
	
	Optional<City> findById(final Integer id);
	City findGradByName(final String name);
}
