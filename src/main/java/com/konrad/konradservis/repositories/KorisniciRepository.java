package com.konrad.konradservis.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.konrad.konradservis.models.Korisnik;

@Transactional
public interface KorisniciRepository extends CrudRepository<Korisnik, Integer>  {
	Optional<Korisnik> findById(Integer id);
}
