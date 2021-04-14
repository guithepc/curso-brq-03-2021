package br.com.brq.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardError {

	private Long timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
