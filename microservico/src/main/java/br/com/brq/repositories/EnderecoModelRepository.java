package br.com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.brq.models.EnderecoModel;

public interface EnderecoModelRepository extends JpaRepository<EnderecoModel, Integer> {
	
	@Query (value = "SELECT * FROM endereco where logradouro like %:logradouro%", nativeQuery = true)
	List<EnderecoModel> findByLogradouroContains(String logradouro);
}
