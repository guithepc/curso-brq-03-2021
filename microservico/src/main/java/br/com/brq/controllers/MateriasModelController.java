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

import br.com.brq.dtos.MateriaDTO;
import br.com.brq.models.MateriaModel;
import br.com.brq.services.MateriaModelService;

@RequestMapping("materias")
@RestController
public class MateriasModelController {
	
	@Autowired
	private MateriaModelService service;
	
	@GetMapping("")
	public List<MateriaDTO> findAll(){
		return this.service.findAll();
	}
	
	
	// alunos/3
	
	
	@GetMapping("{id}")
	public MateriaDTO findOne( @PathVariable("id") int id  ) {
		
		return this.service.findOne(id);						
	}
	
	@GetMapping("procurar-por-nome/{nomeBusca}")
	public List <MateriaDTO> procurarPorNome(@PathVariable String nomeBusca){
		return this.service.procurarPorNome(nomeBusca);
	}
	
	@PostMapping("")
	public MateriaDTO save( @RequestBody MateriaModel obj ) {
					
		return this.service.save(obj);		
	}
	
	
	@PatchMapping("{id}")
	public MateriaDTO update( @RequestBody MateriaModel newObj, @PathVariable int id ) {
		return this.service.update(id, newObj);
	}
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		
		this.service.delete(id);
	}
		
}