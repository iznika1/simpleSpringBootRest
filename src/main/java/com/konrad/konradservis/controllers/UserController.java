package com.konrad.konradservis.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.konradservis.excepions.UserNotExistsException;
import com.konrad.konradservis.models.User;
import com.konrad.konradservis.repositories.UserRepository;

@RestController
@RequestMapping("/korisnici")
public class UserController {
	
	@Autowired
	UserRepository korisniciRepository;
	
	@GetMapping(path="/")
	public @ResponseBody Iterable<User> getAllGrads() {
		return korisniciRepository.findAll();
	}
	
	@GetMapping(path="/korisnik/{korisnikId}")
	public @ResponseBody User findOne(@PathVariable(name = "korisnikId") Integer korisnikId) {
		validateKorisnik(korisnikId);
		return korisniciRepository.findOne(korisnikId);
	}
	
	@DeleteMapping(path="/korisnik/{korisnikId}")
	public @ResponseBody void deleteKorisnik(@PathVariable(name = "korisnikId") Integer korisnikId) {
		validateKorisnik(korisnikId);
		korisniciRepository.delete(korisnikId);
	}
	
	private void validateKorisnik(Integer id) {
		this.korisniciRepository.findById(id).orElseThrow(
				() -> new UserNotExistsException(String.valueOf(id)));
	}
	
	@PostMapping(path="/korisnik")
	public @ResponseBody User saveKorisnik(@RequestBody @Valid User korisnik) {
		return korisniciRepository.save(korisnik);
	}
	

}
