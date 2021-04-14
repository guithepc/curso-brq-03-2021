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

import br.com.brq.dtos.EnderecoDTO;
import br.com.brq.models.EnderecoModel;
import br.com.brq.services.EnderecoModelService;

@RequestMapping("enderecos")
@RestController
public class EnderecoController {

	@Autowired
	private EnderecoModelService enderecoModelService;
	
	@GetMapping("")
	public List<EnderecoDTO> findAll(){
		return this.enderecoModelService.findAll();
	}
	
	@GetMapping("{id}")
	public EnderecoDTO findOne (@PathVariable int id) {
		return this.enderecoModelService.findOne(id);
	}
	
	@GetMapping("procurar-por-logradouro/{logradouroBusca}")
	public List<EnderecoDTO> procurarPorLogradouro (@PathVariable String logradouroBusca){
		return this.enderecoModelService.procurarPorLogradouro(logradouroBusca);
	}
	
	@PostMapping("")
	public EnderecoDTO save (@RequestBody EnderecoModel novoEnderecoModel) {
		return this.enderecoModelService.save(novoEnderecoModel);
	}
	
	@PatchMapping("{id}")
	public EnderecoDTO update (@PathVariable Integer id, @RequestBody EnderecoModel alterarEnderecoModel) {
		return this.enderecoModelService.update(id, alterarEnderecoModel);
	}
	
	@DeleteMapping("{id}")
	public void delete (@PathVariable Integer id) {
		this.enderecoModelService.delete(id);
	}
}
