package br.com.brq.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.com.brq.models.AlunoModel;

@Service
public class AlunoService {
	
	
	public AlunoModel findByMatricula(ArrayList<AlunoModel> alunos, int matricula) {
		
		AlunoModel response = null;
		
		for (AlunoModel alunoModel : alunos) { 
			if (alunoModel.getMatricula() == matricula) {
				response = alunoModel;
			}
		}
		return response;
	}
	
}
