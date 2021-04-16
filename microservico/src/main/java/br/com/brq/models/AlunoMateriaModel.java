package br.com.brq.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "aluno_materia")
public class AlunoMateriaModel {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "aluno_materia_seq")
	@SequenceGenerator ( name = "aluno_materia_seq" , sequenceName = "aluno_materia_seq", allocationSize = 1 )
	private int id;
	
	@Column(name = "aluno_id")	
	private int alunoId;
	
	@Column (name = "materia_id")
	private int materiaId;
	
}