package br.com.mendes.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.mendes.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerApi {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ObjectErro ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
		
		return new ObjectErro(e.getMessage(), e.getCause().toString() ,HttpStatus.BAD_REQUEST.toString());
	}

}
