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

import com.konrad.konradservis.excepions.CityNotFoundException;
import com.konrad.konradservis.models.City;
import com.konrad.konradservis.repositories.CityRepository;

@RestController
@RequestMapping("/gradovi")
public class CityController {
	
	@Autowired
	CityRepository gradRepository;
	
	@GetMapping(path="/")
	public @ResponseBody Iterable<City> getAllGrads() {
		return gradRepository.findAll();
	}
	
	@DeleteMapping(path="/grad/{gradId}")
	public @ResponseBody void deleteKorisnik(@PathVariable(name = "gradId") Integer gradId) {
		validateGrad(gradId);
		gradRepository.delete(gradId);
	}
	
	private void validateGrad(Integer id) {
		this.gradRepository.findById(id).orElseThrow(
				() -> new CityNotFoundException(String.valueOf(id)));
	}
	
	@PostMapping(path="/grad")
	public @ResponseBody City saveOrUpdateGrad(@RequestBody @Valid City grad) {
		
		if(grad.getId() == null && gradRepository.findGradByName(grad.getName()) != null){
			City existingCity = gradRepository.findGradByName(grad.getName());
			grad = existingCity;
		}
		
		return gradRepository.save(grad);
	}
	
	

}
