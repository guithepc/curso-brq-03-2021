package br.com.brq.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.brq.dtos.EscolaDTO;
import lombok.Data;

@Data
@Entity
@Table(name = "escola")

public class EscolaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="escola_seq")
	@SequenceGenerator(name = "escola_seq", sequenceName = "escola_seq", allocationSize = 1)
	private int id;
	private String nome;
	private String tipo_escola;
	private int numero_salas;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "escola")
	private List<AlunoModel> alunos = new ArrayList<>();
	
	public EscolaDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EscolaDTO.class);
	}
	
	
}
