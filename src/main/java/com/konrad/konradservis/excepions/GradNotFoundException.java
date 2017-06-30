package com.konrad.konradservis.excepions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GradNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2834563626713512928L;

	public GradNotFoundException(String msg){
		super("Grad sa id: '" + msg + "' ne postoji.");
	}
}
