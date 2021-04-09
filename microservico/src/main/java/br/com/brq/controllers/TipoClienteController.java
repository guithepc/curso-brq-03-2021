package br.com.brq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.models.TipoCliente;
import br.com.brq.services.TipoClienteService;

@RestController
public class TipoClienteController {
	
	@Autowired
	private TipoClienteService tipoClienteService;

	@GetMapping("tipo-clientes")
	public List<TipoCliente> findAll(){
		return this.tipoClienteService.findAll();
		
		
	}
}