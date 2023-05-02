package com.clubNautico.api.exeption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerError {
	
	@ExceptionHandler(NotFoundSocioException.class)
	public ResponseEntity<ApiError> handleSocioNotFoundException(NotFoundSocioException e) {
	ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
}
	@ExceptionHandler(NotFoundPatronException.class)
	public ResponseEntity<ApiError> handlePatronNotFoundException(NotFoundPatronException e) {
	ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
}
	@ExceptionHandler(NotFoundBarcoException.class)
	public ResponseEntity<ApiError> handleBarcoNotFoundException(NotFoundBarcoException e) {
	ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
	List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
	.collect(Collectors.toList());
	return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
}

	private Map<String, List<String>> getErrorsMap(List<String> errors) {
	Map<String, List<String>> errorResponse = new HashMap<>();
	errorResponse.put("errors", errors);
	return errorResponse;
	
	}
}
