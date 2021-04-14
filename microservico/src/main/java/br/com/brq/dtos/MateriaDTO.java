package br.com.brq.dtos;

import org.modelmapper.ModelMapper;

import com.sun.istack.NotNull;

import br.com.brq.models.MateriaModel;
import lombok.Data;

@Data
public class MateriaDTO {
	
	private int id;
	
	
	@NotNull
	private String nome;
	
	public MateriaModel toEntity(){
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, MateriaModel.class);
	}
	
}


