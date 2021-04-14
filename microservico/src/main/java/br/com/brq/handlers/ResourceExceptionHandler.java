package br.com.brq.handlers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.brq.exceptions.FieldMessageList;
import br.com.brq.exceptions.ObjetoNaoEncontradoException;
import br.com.brq.exceptions.StandardError;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler (MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validador(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		FieldMessageList error = new FieldMessageList(
				 new Date(), 500, 
				"Exceção", 
				"Erro ao validar os dados", 
				request.getRequestURI()
		);
		
		for (FieldError fe: e.getBindingResult().getFieldErrors() ) {
			error.addError(fe.getField(), fe.getDefaultMessage());
		}
				
		return ResponseEntity.status(500).body(error);
	}
	
	@ExceptionHandler (ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado( ObjetoNaoEncontradoException e, HttpServletRequest request ) {
		StandardError error = new StandardError(
				new Date(), 
				404, 
				"Objeto Não Encontrado", 
				e.getMessage(), 
				request.getRequestURI()
		);
		
		return ResponseEntity.status(404).body(error);
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
