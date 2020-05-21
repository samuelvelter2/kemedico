package br.com.kemedico.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Especializacao {
	@Id
	private int idEsp;
	private String descEsp;
	@ManyToMany
	private Set<ProfissionalSaude> profissionais;
	public int getIdEsp() {
		return idEsp;
	}
	public void setIdEsp(int idEsp) {
		this.idEsp = idEsp;
	}
	public String getDescEsp() {
		return descEsp;
	}
	public void setDescEsp(String descEsp) {
		this.descEsp = descEsp;
	}
	public Set<ProfissionalSaude> getProfissionais() {
		return profissionais;
	}
	public void setProfissionais(Set<ProfissionalSaude> profissionais) {
		this.profissionais = profissionais;
	}
	
	
	
}
