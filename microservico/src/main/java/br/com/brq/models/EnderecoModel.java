package br.com.brq.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.brq.dtos.EnderecoDTO;
import lombok.Data;

@Data
@Entity
@Table(name  = "endereco")
public class EnderecoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="endereco_seq")
	@SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq", allocationSize = 1)//notação p/ MySQL saber que é autoincrement
	private int id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;

	@JsonIgnore // ignora o json  do  looping
	@OneToOne
	@JoinColumn (name = "aluno_id")
	private AlunoModel aluno;
	
	public EnderecoDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EnderecoDTO.class);
	}

}
