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

import br.com.brq.dtos.EscolaDTO;
import br.com.brq.models.EscolaModel;
import br.com.brq.services.EscolaModelServices;

@RequestMapping("escolas")
@RestController
public class EscolaController {
	
	@Autowired
	private EscolaModelServices escolaModelService;
	
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
	public  EscolaDTO save (@RequestBody EscolaModel novoEscolaModel) {
		return this.escolaModelService.save(novoEscolaModel);
	}
	
	
	@PatchMapping("/{id}")
	public EscolaDTO update(@PathVariable Integer id, @RequestBody EscolaModel novoEscolaModel) {
		return this.escolaModelService.update(id, novoEscolaModel);
	}
	
	@DeleteMapping("/{matriculaaluno}")
	public void delete (@PathVariable Integer id) {
		this.escolaModelService.delete(id);
	}
	
}
