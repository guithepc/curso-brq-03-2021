package br.com.brq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brq.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{

	public UsuarioModel findByEmail(String email);
}

