package br.com.brq.models;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import javax.persistence.JoinColumn;
import br.com.brq.dtos.UsuarioLoginDTO;
import br.com.brq.models.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "usuario_seq_id" )
	@SequenceGenerator ( sequenceName = "usuario_seq_id", name = "usuario_seq_id", allocationSize = 1 )
	private int id;
		
	private String nome;	
	private String senha;
	private String email;
		
	@ElementCollection(fetch = FetchType.EAGER) //faz inner join e traz a requisição - força a consulta
	@CollectionTable(name = "PERFIS", joinColumns = @JoinColumn (name = "usuario_id") ) //tabela auxiliar, PRA GUARDAR OS PERFIS DE CADA USUARIO
	private Set<Integer> perfis = new HashSet<>(); //set é uma maneira boa de criar uma lista que não se repete (int)
	
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		if (perfis == null) {
			perfis = new HashSet<>();
		}
		
		perfis.add( perfil.getCodigo() );
	}
	
	public UsuarioLoginDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, UsuarioLoginDTO.class);
	}
	
}
