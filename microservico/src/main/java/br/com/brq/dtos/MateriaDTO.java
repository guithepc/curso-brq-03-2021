package br.com.brq.dtos;

import javax.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;



import br.com.brq.models.MateriaModel;
import lombok.Data;

@Data
public class MateriaDTO {
	
	private int id;
	
	
	@NotNull
	private String nome;
	
	
	@NotNull
	private String professor;
	
	public MateriaModel toEntity(){
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, MateriaModel.class);
	}
	
}


