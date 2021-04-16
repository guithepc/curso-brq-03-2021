package br.com.brq.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.brq.models.EscolaModel;
import lombok.Data;

@Data
public class EscolaDTO {
	
	private int id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String tipo_escola;

	@NotNull
	private int numero_salas;
	

	public EscolaModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EscolaModel.class);
	}
}
