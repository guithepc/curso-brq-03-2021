package br.com.brq.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "escola")

public class EscolaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String tipo_escola;
	private int numero_salas;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "escola")
	private List<AlunoModel> alunos = new ArrayList<>();
	
	
}
