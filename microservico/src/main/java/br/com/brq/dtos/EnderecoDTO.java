package br.com.brq.dtos;

import lombok.Data;

@Data
public class EnderecoDTO {
	
	private int id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	
}
