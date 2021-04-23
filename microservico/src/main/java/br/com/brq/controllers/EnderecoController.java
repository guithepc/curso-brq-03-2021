package br.com.brq.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.dtos.EnderecoDTO;
import br.com.brq.services.EnderecoService;

@RequestMapping("enderecos")
@RestController
@CrossOrigin(origins ="*")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoModelService;
	
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
	public EnderecoDTO save (@Valid @RequestBody EnderecoDTO novoEnderecoModel) {
		return this.enderecoModelService.save(novoEnderecoModel);
	}
	
	@PatchMapping("{id}")
	public EnderecoDTO update (@PathVariable Integer id, @Valid @RequestBody EnderecoDTO alterarEnderecoModel) {
		return this.enderecoModelService.update(id, alterarEnderecoModel);
	}
	
	@DeleteMapping("{id}")
	public void delete (@PathVariable Integer id) {
		this.enderecoModelService.delete(id);
	}
	
	@GetMapping("paginacao")
	public ResponseEntity<Page<EnderecoDTO>> paginacao(
			@RequestParam( name = "pagina", defaultValue = "0" ) int pagina,
			@RequestParam ( name = "registros" , defaultValue = "10") int registros  ) {
		Page<EnderecoDTO> pageDTO = this.enderecoModelService.paginacao(pagina, registros);
		return ResponseEntity.ok().body(pageDTO);
	}
}




