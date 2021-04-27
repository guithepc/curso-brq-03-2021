package br.com.brq.security;


import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.brq.models.enums.Perfil;

public class CredencialSecurityModel implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String senha;
	private String nome;
	private Collection<? extends GrantedAuthority> authorities;
	
	public CredencialSecurityModel() {
	}
	
	public CredencialSecurityModel(int id, String email, String senha, String nome, Set<Perfil> perfis ) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	
		 // Converte a coleção de perfis vindo do banco de dados para uma coleção de SimpleGrantedAuthority 
		
		this.authorities = perfis.stream().map(
				x -> new SimpleGrantedAuthority(
						x.getDescricao()
					)
				).collect(
						Collectors.toList()
				);
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	
	 // Converter SimpleGrantedAuthority para uma String separados por ,
	 
	
	public String getAuthorityToString() {
		final String authoritiesStr = authorities.stream()
                .map(
                		GrantedAuthority::getAuthority
                		)
                .collect(Collectors.joining(","));
		return authoritiesStr;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	
	public String getNome() {
		return nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));		
	}
	
	

	@Override
	public String toString() {
		return "CredencialSecurityModel [id=" + id + ", email=" + email + ", senha=" + senha + ", nome=" + nome
				+ ", authorities=" + authorities + "]";
	}

}