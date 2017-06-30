package com.konrad.konradservis.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.konrad.konradservis.models.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer>  {
	Optional<User> findById(Integer id);
}
