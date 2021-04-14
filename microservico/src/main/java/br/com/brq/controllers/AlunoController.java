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

import br.com.brq.dtos.AlunoDTO;
import br.com.brq.models.AlunoModel;

import br.com.brq.services.AlunoModelService;

@RequestMapping("alunos")
@RestController

public class AlunoController {
	
	@Autowired
	private AlunoModelService alunoModelService;
	
	@GetMapping("")
	public List<AlunoDTO> findAll(){
		return this.alunoModelService.findAll();
	}
	
	
	@GetMapping("/{matriculaaluno}")
	public AlunoDTO findOne (@PathVariable int matriculaaluno) {
		return this.alunoModelService.findOne(matriculaaluno);
	}
	
	@GetMapping("procurar-por-nome/{nomeBusca}")
	public List <AlunoDTO> procurarPorNome(@PathVariable String nomeBusca){
		return this.alunoModelService.procurarPorNome(nomeBusca);
	}
	
	@PostMapping("")
	public  AlunoDTO save (@RequestBody AlunoModel novoAlunoModel) {
		return this.alunoModelService.save(novoAlunoModel);
	}
	
	
	@PatchMapping("/{matriculaaluno}")
	public AlunoDTO update(@PathVariable Integer matriculaaluno, @RequestBody AlunoModel alterarAlunoModel) {
		return this.alunoModelService.update(matriculaaluno, alterarAlunoModel);
	}
	
	@DeleteMapping("/{matriculaaluno}")
	public void delete (@PathVariable Integer matriculaaluno) {
		this.alunoModelService.delete(matriculaaluno);
	}
	
	
}
