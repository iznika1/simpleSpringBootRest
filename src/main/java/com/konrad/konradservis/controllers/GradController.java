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

import com.konrad.konradservis.excepions.GradNotFoundException;
import com.konrad.konradservis.models.Grad;
import com.konrad.konradservis.repositories.GradRepository;

@RestController
@RequestMapping("/gradovi")
public class GradController {
	
	@Autowired
	GradRepository gradRepository;
	
	@GetMapping(path="/")
	public @ResponseBody Iterable<Grad> getAllGrads() {
		return gradRepository.findAll();
	}
	
	@DeleteMapping(path="/grad/{gradId}")
	public @ResponseBody void deleteKorisnik(@PathVariable(name = "gradId") Integer gradId) {
		validateGrad(gradId);
		gradRepository.delete(gradId);
	}
	
	private void validateGrad(Integer id) {
		this.gradRepository.findById(id).orElseThrow(
				() -> new GradNotFoundException(String.valueOf(id)));
	}
	
	@PostMapping(path="/grad")
	public @ResponseBody Grad saveOrUpdateGrad(@RequestBody @Valid Grad grad) {
		
		if(grad.getId() == null && gradRepository.findGradByName(grad.getName()) != null){
			Grad existingCity = gradRepository.findGradByName(grad.getName());
			grad = existingCity;
		}
		
		return gradRepository.save(grad);
	}
	
	

}
