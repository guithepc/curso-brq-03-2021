package br.com.brq.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.brq.models.AlunoModel;
import lombok.Data;

@Data
public class AlunoDTO {

	private int matriculaAluno;
	@NotNull
	private String nomeAluno;
	
	@NotNull
	private String turmaAluno;
	
	private EnderecoDTO endereco;
	
	public AlunoModel toEntity(){
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, AlunoModel.class);
	}
	
}
