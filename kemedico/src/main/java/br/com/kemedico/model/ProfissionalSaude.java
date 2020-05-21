package br.com.kemedico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_profissisonal_saude")
public class ProfissionalSaude extends Usuario {
	private String crm;
	@ManyToOne
	private Especializacao especializacao1;
	@ManyToOne
	private Especializacao especializacao2;
	@ManyToMany
	private List<Clinica> clinicas;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	public Especializacao getEspecializacao2() {
		return especializacao2;
	}

	public void setEspecializacao2(Especializacao especializacao2) {
		this.especializacao2 = especializacao2;
	}

	public Especializacao getEspecializacao1() {
		return especializacao1;
	}

	public void setEspecializacao1(Especializacao especializacao1) {
		this.especializacao1 = especializacao1;
	}

}
