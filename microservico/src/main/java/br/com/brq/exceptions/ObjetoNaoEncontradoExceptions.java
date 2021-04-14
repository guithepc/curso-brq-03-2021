package br.com.brq.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {

	public ObjetoNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
}