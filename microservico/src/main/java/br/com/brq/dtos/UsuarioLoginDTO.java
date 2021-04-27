package br.com.brq.dtos;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;

import br.com.brq.models.UsuarioModel;
import lombok.Data;

@Data
public class UsuarioLoginDTO {
	
	private int id;
	
	private String nome;	
	private String senha;
	private String email;		
	private Set<Integer> perfis = new HashSet<>();
	
	public UsuarioModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, UsuarioModel.class);		
	}

}