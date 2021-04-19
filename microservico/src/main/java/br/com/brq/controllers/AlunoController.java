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

import br.com.brq.dtos.AlunoDTO;
import br.com.brq.dtos.MateriaDTO;
import br.com.brq.services.AlunoService;

@RequestMapping("alunos")
@RestController
@CrossOrigin(origins ="*")

public class AlunoController {
	
	@Autowired
	private AlunoService alunoModelService;
	
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
	public  AlunoDTO save (@Valid @RequestBody AlunoDTO novoAlunoModel) {
		return this.alunoModelService.save(novoAlunoModel);
	}
	
	
	@PatchMapping("/{matriculaaluno}")
	public AlunoDTO update(@PathVariable Integer matriculaaluno,@Valid @RequestBody AlunoDTO alterarAlunoModel) {
		return this.alunoModelService.update(matriculaaluno, alterarAlunoModel);
	}
	
	@DeleteMapping("/{matriculaaluno}")
	public void delete (@PathVariable Integer matriculaaluno) {
		this.alunoModelService.delete(matriculaaluno);
	}
	
	@GetMapping("paginacao")
	public ResponseEntity<Page<AlunoDTO>> paginacao(
			@RequestParam( name = "pagina", defaultValue = "0" ) int pagina,
			@RequestParam ( name = "registros" , defaultValue = "10") int registros  ) {
		
		Page<AlunoDTO> pageDTO = this.alunoModelService.paginacao(pagina, registros);
		
		return ResponseEntity.ok().body(pageDTO);
		
	}
	
	
}
