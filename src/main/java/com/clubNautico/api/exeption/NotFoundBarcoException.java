package com.clubNautico.api.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundBarcoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundBarcoException(Integer id) {
		super("No se puede encontrar el barco con matricula: "+ id);
	}
	
}
