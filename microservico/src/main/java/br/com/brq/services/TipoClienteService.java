package br.com.brq.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.models.TipoCliente;
import br.com.brq.repositories.TipoClienteRepository;

@Service
public class TipoClienteService {

	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	public List<TipoCliente> findAll(){
		return this.tipoClienteRepository.findAll();
	}
}
