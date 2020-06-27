package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Especializacao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idEsp;
	private String descEsp;
	public Especializacao() {
		super();
	}
	
	
	public Especializacao(String descEsp) {
		super();
		this.descEsp = descEsp;
	}

	
	public String getDescEsp() {
		return descEsp;
	}
	public void setDescEsp(String descEsp) {
		this.descEsp = descEsp;
	}
	@Override
	public String toString() {
		return "Especializacao [idEsp=" + idEsp + ", descEsp=" + descEsp + "]";
	}


	public void setIdEsp(long idEsp) {
		this.idEsp = idEsp;
	}


	public long getIdEsp() {
		return idEsp;
	}
	
	
	
	
}
