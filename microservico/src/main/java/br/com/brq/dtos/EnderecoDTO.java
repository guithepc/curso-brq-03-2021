package br.com.brq.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.brq.models.EnderecoModel;
import lombok.Data;

@Data
public class EnderecoDTO {
	
	private int id;
	@NotNull
	private String logradouro;
	@NotNull
	private String numero;
	
	private String complemento;
	
	@NotNull
	private String cep;
	
	public EnderecoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, EnderecoModel.class);
	}
	
}
