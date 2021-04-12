package br.com.brq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.models.TipoCliente;
import br.com.brq.services.TipoClienteService;


@RequestMapping("tipo-clientes")//pega sempre com esse inicio de path
@RestController
public class TipoClienteController {
	
	@Autowired
	private TipoClienteService tipoClienteService;

	@GetMapping("")
	public List<TipoCliente> findAll(){
		return this.tipoClienteService.findAll();
		
		
	}
	
	@GetMapping ("/{idtipocliente}")
	public TipoCliente findOne (@PathVariable int idtipocliente) {
		return this.tipoClienteService.findOne(idtipocliente);
		
		
	}
	
	@PostMapping("")
	public TipoCliente save(@RequestBody TipoCliente novoTipoCliente) {
		return this.tipoClienteService.save(novoTipoCliente);
	}
	
	@PatchMapping("/{idtipocliente}")
	public TipoCliente update(@PathVariable Integer idtipocliente, @RequestBody TipoCliente alterarTipoCliente ) {
		return this.tipoClienteService.update(idtipocliente, alterarTipoCliente);
	}
	
	@DeleteMapping("/{idtipocliente}")
	public void delete (@PathVariable Integer idtipocliente) {
		this.tipoClienteService.delete(idtipocliente);
	}
	
}