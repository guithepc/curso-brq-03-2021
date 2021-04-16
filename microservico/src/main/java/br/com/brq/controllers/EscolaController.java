package br.com.brq.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.dtos.EscolaDTO;
import br.com.brq.models.EscolaModel;
import br.com.brq.services.EscolaServices;

@RequestMapping("escolas")
@RestController
public class EscolaController {
	
	@Autowired
	private EscolaServices escolaModelService;
	
	@GetMapping("")
	public List <EscolaDTO> findAll(){
		return this.escolaModelService.findAll();
	}
	
	
	@GetMapping("/{id}")
	public EscolaDTO findOne (@PathVariable int id) {
		return this.escolaModelService.findOne(id);
	}
	
	@GetMapping("procurar-por-nome/{nomeBusca}")
	public List<EscolaDTO> procurarPorNome(@PathVariable String nomeBusca){
		return this.escolaModelService.procurarPorNome(nomeBusca);
	}
	
	@PostMapping("")
	public  EscolaDTO save (@Valid @RequestBody EscolaDTO novoEscolaModel) {
		return this.escolaModelService.save(novoEscolaModel);
	}
	
	
	@PatchMapping("/{id}")
	public EscolaDTO update(@PathVariable Integer id, @Valid @RequestBody EscolaDTO novoEscolaModel) {
		return this.escolaModelService.update(id, novoEscolaModel);
	}
	
	@DeleteMapping("/{matriculaaluno}")
	public void delete (@PathVariable Integer id) {
		this.escolaModelService.delete(id);
	}
	
	@GetMapping("paginacao")
	public ResponseEntity<Page<EscolaDTO>> paginacao(
			@RequestParam(name = "pagina", defaultValue = "0") int pagina,
			@RequestParam(name = "registros", defaultValue = "10") int registros){
		Page <EscolaDTO> pageDTO = this.escolaModelService.paginacao(pagina, registros);
		
		return ResponseEntity.ok().body(pageDTO);
	}
	
}
