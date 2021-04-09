package br.com.brq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brq.models.TipoCliente;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Integer>{
	
		
}
