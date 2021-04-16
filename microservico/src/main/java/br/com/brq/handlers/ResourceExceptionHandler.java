package br.com.brq.handlers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.brq.exceptions.FieldMessageList;

import br.com.brq.exceptions.ObjetoNaoEncontradoExceptions;
import br.com.brq.exceptions.StandardError;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler (MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validador(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		FieldMessageList error = new FieldMessageList(
				 new Date(), HttpStatus.UNPROCESSABLE_ENTITY.value(), 
				"Exceção", 
				"Erro ao validar os dados", 
				request.getRequestURI()
		);
		
		for (FieldError fieldErrorObj: e.getBindingResult().getFieldErrors() ) {
			error.addError(fieldErrorObj.getField(), fieldErrorObj.getDefaultMessage());
		}
				
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(error);
	}
	
	@ExceptionHandler (ObjetoNaoEncontradoExceptions.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado( ObjetoNaoEncontradoExceptions e, HttpServletRequest request ) {
		StandardError error = new StandardError(
				new Date(), 
				HttpStatus.NOT_FOUND.value(), 
				"Objeto Não Encontrado", 
				e.getMessage(), 
				request.getRequestURI()
		);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity <StandardError> runtimeEx(RuntimeException e, HttpServletRequest request){
		StandardError error = new StandardError(
				new Date(), 
				500, 
				"Contate o suporte", 
				e.getMessage(), 
				request.getRequestURI()
		);
		
		return ResponseEntity.status(500).body(error);
		
	}
}
