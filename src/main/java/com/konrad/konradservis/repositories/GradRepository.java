package com.konrad.konradservis.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.konrad.konradservis.models.Grad;

@Transactional
public interface GradRepository extends CrudRepository<Grad, Integer>  {
	
	Optional<Grad> findById(final Integer id);
	Grad findGradByName(final String name);
}
