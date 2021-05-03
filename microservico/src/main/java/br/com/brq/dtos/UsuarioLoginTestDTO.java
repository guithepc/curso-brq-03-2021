package br.com.brq.dtos;

import org.modelmapper.ModelMapper;

import br.com.brq.models.UsuarioModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioLoginTestDTO {
		
	private String senha;
	private String email;		
		
	public UsuarioModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, UsuarioModel.class);		
	}

}