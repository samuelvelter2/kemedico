package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Role(String nome) {		
		this.nome = nome;
	}
	public Role() {
		super();
	}


	@Id
	private String nome;

	public String getNome() {
		return nome;
	}
	

	

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	@Override
	public String toString() {
		return "Role [nome=" + nome + "]";
	}
	
}
