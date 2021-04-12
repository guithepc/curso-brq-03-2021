package br.com.brq.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


@Table(name = "aluno")
public class AlunoModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //notação p/ MySQL saber que é autoincrement
	private Integer matriculaaluno; // aqui sempre deve estar alinhado com o banco de dados
	
	private String nomealuno;
	
	private String turmaaluno;
		
	@OneToOne(mappedBy = "aluno") //mapeada por "aluno" em endereco
	private EnderecoModel endereco;
	
	@ManyToOne
	@JoinColumn(name = "escola_id")
	private EscolaModel escola;
}