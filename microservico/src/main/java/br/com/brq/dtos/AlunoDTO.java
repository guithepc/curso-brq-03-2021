package br.com.brq.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.brq.models.AlunoModel;
import lombok.Data;

@Data
public class AlunoDTO {

	private int matriculaaluno;
	@NotNull
	private String nomealuno;
	
	@NotNull
	private String turmaaluno;
	
	private EnderecoDTO endereco;
	
	public AlunoModel toEntity(){
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, AlunoModel.class);
	}
	
}
