package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rg;
	private String apelido;
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
}
