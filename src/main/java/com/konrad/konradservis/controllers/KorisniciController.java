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

import com.konrad.konradservis.excepions.KorisnikNotExistsException;
import com.konrad.konradservis.models.Korisnik;
import com.konrad.konradservis.repositories.KorisniciRepository;

@RestController
@RequestMapping("/korisnici")
public class KorisniciController {
	
	@Autowired
	KorisniciRepository korisniciRepository;
	
	@GetMapping(path="/")
	public @ResponseBody Iterable<Korisnik> getAllGrads() {
		return korisniciRepository.findAll();
	}
	
	@GetMapping(path="/korisnik/{korisnikId}")
	public @ResponseBody Korisnik findOne(@PathVariable(name = "korisnikId") Integer korisnikId) {
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
				() -> new KorisnikNotExistsException(String.valueOf(id)));
	}
	
	@PostMapping(path="/korisnik")
	public @ResponseBody Korisnik saveKorisnik(@RequestBody @Valid Korisnik korisnik) {
		return korisniciRepository.save(korisnik);
	}
	

}
