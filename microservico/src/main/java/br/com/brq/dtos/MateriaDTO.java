package br.com.brq.dtos;

import java.util.List;

import javax.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;

import br.com.brq.models.AlunoModel;
import br.com.brq.models.MateriaModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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


