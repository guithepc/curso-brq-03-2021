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

import br.com.brq.dtos.MateriaDTO;
import br.com.brq.services.MateriaService;

@RequestMapping("materias")
@RestController
@CrossOrigin(origins ="*")
public class MateriasModelController {
	
	@Autowired
	private MateriaService service;
	
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
	public MateriaDTO save(@Valid @RequestBody MateriaDTO obj ) {
					
		return this.service.save(obj);		
	}
	
	
	@PatchMapping("{id}")
	public MateriaDTO update(@Valid @RequestBody MateriaDTO newObj, @PathVariable int id ) {
		return this.service.update(id, newObj);
	}
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		
		this.service.delete(id);
	}
	

	@DeleteMapping("many/{id}")
	public void deleteMany(@PathVariable int[] id) {
		
		this.service.deleteMany(id);
	}
	
	
	@GetMapping("paginacao")
	public ResponseEntity<Page<MateriaDTO>> paginacao(
			@RequestParam( name = "pagina", defaultValue = "0" ) int pagina,
			@RequestParam ( name = "registros" , defaultValue = "10") int registros  ) {
		
		Page<MateriaDTO> pageDTO = this.service.paginacao(pagina, registros);
		
		return ResponseEntity.ok().body(pageDTO);
		
	}
	
		
}






