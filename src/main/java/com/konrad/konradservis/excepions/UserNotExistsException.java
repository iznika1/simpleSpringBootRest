package com.konrad.konradservis.excepions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2528951005132769192L;
	
	public UserNotExistsException(String msg)
	{
		super("Korisnik sa id: '" + msg + "' ne postoji.");
	}


}
