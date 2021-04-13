package br.com.brq.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.models.EscolaModel;
import br.com.brq.repositories.EscolaModelRepository;

@Service
public class EscolaModelServices {
	
	
	@Autowired
	private EscolaModelRepository escolaModelRepository;

	public List<EscolaModel> findAll(){
		return this.escolaModelRepository.findAll();
	}
	
	public EscolaModel findOne(Integer id){
		return this.escolaModelRepository.findById(id).orElseThrow(() -> new RuntimeException ("Error### Escola não encontrado"));
	}
	
	public EscolaModel save (EscolaModel novoEscolaModel) {
		return this.escolaModelRepository.save(novoEscolaModel);
	}
	
	public EscolaModel update (Integer id, EscolaModel alterarEscolaModel) {
		Optional<EscolaModel> opEscolaModel = this.escolaModelRepository.findById(id);
		
		if (opEscolaModel.isPresent()) {
			EscolaModel updated = opEscolaModel.get();
			updated.setNome(alterarEscolaModel.getNome());
			updated.setTipo_escola(alterarEscolaModel.getTipo_escola());
			updated.setNumero_salas(alterarEscolaModel.getNumero_salas());
			
			return this.escolaModelRepository.save(updated);
		} else {
			throw new RuntimeException ("Registro não localizado");

		}
	}
	
	
	public void delete (Integer id) {
		try {
			this.escolaModelRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException ("Erro ao deletar" + e.getMessage());
		}
	}
}




