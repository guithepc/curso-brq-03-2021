package br.com.brq.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.brq.dtos.AlunoDTO;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="aluno_seq")
	@SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_seq", allocationSize = 1)//notação p/ MySQL saber que é autoincrement
	@Column (name = "matriculaaluno")
	private Integer matriculaAluno; // aqui sempre deve estar alinhado com o banco de dados
	
	@Column( name = "nomealuno" )
	private String nomeAluno;
	
	@Column(name = "turmaaluno")
	private String turmaAluno;
		
	@OneToOne(mappedBy = "aluno") //mapeada por "aluno" em endereco - um pra um
	private EnderecoModel endereco;
	
	@ManyToOne //muitos para muitos
	@JoinColumn(name = "escola_id")
	private EscolaModel escola;
	
	
	
	
	@ManyToMany
	@JoinTable(
			name = "aluno_materia",
			joinColumns = @JoinColumn(name = "aluno_id"), //aqui é o join pq estou em AlunoModel
			inverseJoinColumns = @JoinColumn(name = "materia_id")// a outra coluna da outra tabela
			)
	private List<MateriaModel> materias = new ArrayList<>();
	
	public AlunoDTO toDto() {
		ModelMapper modelMapper   = new ModelMapper();
		return modelMapper.map(this, AlunoDTO.class);
	}
	
}




