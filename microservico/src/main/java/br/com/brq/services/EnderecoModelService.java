package br.com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.dtos.EnderecoDTO;
import br.com.brq.models.EnderecoModel;
import br.com.brq.repositories.EnderecoModelRepository;

@Service
public class EnderecoModelService {
	
	@Autowired
	private EnderecoModelRepository enderecoModelRepository;
	
	
	public List<EnderecoDTO> findAll(){
		List<EnderecoModel> list = this.enderecoModelRepository.findAll();
		
		return list.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));	
	}
	
	public EnderecoDTO findOne(Integer id) {
		return this.enderecoModelRepository.findById(id).orElseThrow( () -> new RuntimeException ("Erro")).toDto();
	}
	
	public List<EnderecoDTO> procurarPorLogradouro(String logradouro){
		List<EnderecoModel> list =  this.enderecoModelRepository.findByLogradouroContains(logradouro);
		return list.stream()
				.map(x -> x.toDto())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public EnderecoDTO save (EnderecoModel novoEnderecoModel) {
		return this.enderecoModelRepository.save(novoEnderecoModel).toDto();
	}
	
	
	
	public EnderecoDTO update (Integer id, EnderecoModel alterarEnderecoModel) {
		Optional<EnderecoModel> opEnderecoModel = this.enderecoModelRepository.findById(id);
		
		if (opEnderecoModel.isPresent()) {
			EnderecoModel updated = opEnderecoModel.get();
			updated.setLogradouro(alterarEnderecoModel.getLogradouro());
			updated.setNumero(alterarEnderecoModel.getNumero());
			updated.setComplemento(alterarEnderecoModel.getComplemento());
			updated.setCep(alterarEnderecoModel.getCep());
			
			return this.enderecoModelRepository.save(updated).toDto();
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
