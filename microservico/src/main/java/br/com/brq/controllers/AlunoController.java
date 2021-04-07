package br.com.brq.controllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.brq.models.AlunoModel;
import br.com.brq.services.AlunoService;


@RestController
public class AlunoController {
	
	
	private ArrayList<AlunoModel> alunos = new ArrayList<>();
	
	@Autowired
	private AlunoService alunoService; //= new AlunoService()
	
	@GetMapping("alunos") //endpoint
	public ArrayList<AlunoModel> getAll(){
		return this.alunos;
	}
	
	
	
	@GetMapping("alunos/{matricula}") //pegar o indice da variavel matricula
	public AlunoModel getbyMatricula(@PathVariable int matricula, @RequestParam(value = "q", defaultValue = "") String query) {
		
		AlunoModel response = this.alunoService.findByMatricula(alunos, matricula); //criei variavel response
		
		return response;
	}
	
	@PostMapping("alunos")
	public AlunoModel save(@RequestBody AlunoModel novoAluno) {
		System.out.println(novoAluno);
		this.alunos.add(novoAluno);
		return novoAluno;
		
		
		
	}
	
	
	
	@PatchMapping("alunos/{matricula}") 
	public AlunoModel update(@RequestBody AlunoModel novoAluno, @PathVariable int matricula) {//path pra alterar
		
		AlunoModel response = null;
		
		for (AlunoModel aluno : alunos) {	
			if (aluno.getMatricula() == matricula) {
				
				//aluno.setMatricula( novoAluno.getMatricula() );
				if (novoAluno.getNome() != null)
					aluno.setNome(novoAluno.getNome() );
				if (novoAluno.getTurma() != null)
					aluno.setTurma( novoAluno.getTurma() );
				
				response = aluno;
			}
		}
		return response;
	}
	
	
	
	
	
	@DeleteMapping("alunos/{matricula}")
	public void delete(@PathVariable int matricula) {
		for(int i =0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula() == matricula) {
				alunos.remove(i);
			}
		}
	}
	
	
}
