package br.com.brq.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.models.EnderecoModel;
import br.com.brq.repositories.EnderecoModelRepository;

@Service
public class EnderecoModelService {
	
	@Autowired
	private EnderecoModelRepository enderecoModelRepository;
	
	
	public List<EnderecoModel> findAll(){
		return this.enderecoModelRepository.findAll();
	}
	
	public EnderecoModel findOne(Integer id) {
		return this.enderecoModelRepository.findById(id).orElseThrow( () -> new RuntimeException ("Erro"));
	}
	
	public EnderecoModel save (EnderecoModel novoEnderecoModel) {
		return this.enderecoModelRepository.save(novoEnderecoModel);
	}
	
	public EnderecoModel update (Integer id, EnderecoModel alterarEnderecoModel) {
		Optional<EnderecoModel> opEnderecoModel = this.enderecoModelRepository.findById(id);
		
		if (opEnderecoModel.isPresent()) {
			EnderecoModel updated = opEnderecoModel.get();
			updated.setLogradouro(alterarEnderecoModel.getLogradouro());
			updated.setNumero(alterarEnderecoModel.getNumero());
			updated.setComplemento(alterarEnderecoModel.getComplemento());
			updated.setCep(alterarEnderecoModel.getCep());
			
			return this.enderecoModelRepository.save(updated);
		} else {
			throw new RuntimeException("Registro não localizado");
		}
	}
	
	public void delete(Integer id) {
		try {
			this.enderecoModelRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar ### " + e.getMessage());
		}
	}
	
}
