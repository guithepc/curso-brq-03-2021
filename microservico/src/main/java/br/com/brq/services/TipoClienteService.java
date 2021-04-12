package br.com.brq.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.models.TipoCliente;
import br.com.brq.repositories.TipoClienteRepository;

@Service
public class TipoClienteService {

	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	public List<TipoCliente> findAll(){
		return this.tipoClienteRepository.findAll();
	}
	
	public TipoCliente findOne(Integer idtipocliente) {
//		Optional<TipoCliente> opTipoCli = this.tipoClienteRepository.findById(idtipocliente); // pega o id se estiver presente
//		
//		if (opTipoCli.isPresent()) {
//			return opTipoCli.get();
//		}
//		else {
//			return null;
//		}
		return this.tipoClienteRepository.findById(idtipocliente).orElseThrow(() -> new RuntimeException ("Não encontrado"));
	}
	
	
	public TipoCliente save (TipoCliente novoTipoCliente) {
		return this.tipoClienteRepository.save(novoTipoCliente);
	}
	
	public TipoCliente update(Integer idtipocliente, TipoCliente alterarTipoCliente) {
		Optional<TipoCliente> opTipoCli = this.tipoClienteRepository.findById(idtipocliente);//procura no banco
		
		if(opTipoCli.isPresent()) {
			TipoCliente updated = opTipoCli.get();
			updated.setDesctipocli(alterarTipoCliente.getDesctipocli());
			return this.tipoClienteRepository.save(updated);
			//se existir pega o usuario do banco e altera de acordo com a request
			
		}else {
			
			//return null;
			throw new RuntimeException ("Registro não localizado");
			
		}
		
		
	}
	
	public void delete (Integer idtipocliente) {
		
		try {
			this.tipoClienteRepository.deleteById(idtipocliente);
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar registro" + e.getMessage());
		}
		
	}
	
	
}
