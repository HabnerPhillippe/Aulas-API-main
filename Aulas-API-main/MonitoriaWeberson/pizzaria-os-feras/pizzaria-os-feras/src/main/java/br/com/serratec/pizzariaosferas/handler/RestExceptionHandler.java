package br.com.serratec.pizzariaosferas.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.serratec.pizzariaosferas.model.error.ErrorMessage;
import br.com.serratec.pizzariaosferas.model.exception.ResourceBadRequestException;
import br.com.serratec.pizzariaosferas.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
		
		//Aqui eu estou criando o objeto que vai conter as informações da mensagem personalizada.
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage());

		//Aqui eu estou devolvendo o erro personalizado para o usuario.
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<ErrorMessage> handleResourceBadRequestException(ResourceBadRequestException ex) {
		
		//Aqui eu estou criando o objeto que vai conter as informações da mensagem personalizada.
		ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage());

		//Aqui eu estou devolvendo o erro personalizado para o usuario.
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
}
