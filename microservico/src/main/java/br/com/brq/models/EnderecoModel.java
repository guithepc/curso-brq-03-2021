package br.com.brq.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name  = "endereco")
public class EnderecoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;

	@JsonIgnore // ignora o json  do  looping
	@OneToOne
	@JoinColumn (name = "aluno_id")
	private AlunoModel aluno;

}
