package br.com.brq.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class FieldMessageList extends StandardError {

	public FieldMessageList(Date timestamp, int status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	private List<FieldMessage> errors = new ArrayList<>();
		
	public void addError(String fieldName, String message) {
		errors.add( new FieldMessage(fieldName, message) );
	}
}
