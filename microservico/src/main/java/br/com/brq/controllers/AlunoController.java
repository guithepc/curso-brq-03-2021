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


import br.com.brq.models.AlunoModel;

import br.com.brq.services.AlunoModelService;

@RequestMapping("alunos")
@RestController

public class AlunoController {
	
	@Autowired
	private AlunoModelService alunoModelService;
	
	@GetMapping("")
	public List <AlunoModel> findAll(){
		return this.alunoModelService.findAll();
	}
	
	
	@GetMapping("/{matriculaaluno}")
	public AlunoModel findOne (@PathVariable int matriculaaluno) {
		return this.alunoModelService.findOne(matriculaaluno);
	}
	
	@PostMapping("")
	public  AlunoModel save (@RequestBody AlunoModel novoAlunoModel) {
		return this.alunoModelService.save(novoAlunoModel);
	}
	
	
	@PatchMapping("/{matriculaaluno}")
	public AlunoModel update(@PathVariable Integer matriculaaluno, @RequestBody AlunoModel alterarAlunoModel) {
		return this.alunoModelService.update(matriculaaluno, alterarAlunoModel);
	}
	
	@DeleteMapping("/{matriculaaluno}")
	public void delete (@PathVariable Integer matriculaaluno) {
		this.alunoModelService.delete(matriculaaluno);
	}
	
	
}
