package com.clubNautico.api.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundPatronException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundPatronException(Integer id) {
		super("No se puede encontrar el patron con id: "+ id);
	}
	
	public NotFoundPatronException() {
		super("No se ha podido acceder a la base de datos, o no existe ningun patrón.");
	}
	
}
