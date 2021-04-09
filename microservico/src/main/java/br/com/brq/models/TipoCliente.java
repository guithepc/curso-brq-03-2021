package br.com.brq.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //mapeamento com banco

@Table(name = "tipocliente") //esta classe esta endo mapeada com essa tabela
public class TipoCliente {
	@Id
	private Integer idtipocliente;
	private String desctipocli;
}
