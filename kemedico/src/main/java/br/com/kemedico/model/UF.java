package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UF {
	public UF(String nomeUF,String sgUF) {
		this.nomeUF = nomeUF;
		this.sgUF = sgUF;
	}
	public UF() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idUF;
	private String nomeUF;
	private String sgUF;

	public String getNomeUF() {
		return nomeUF;
	}

	public void setNomeUF(String nomeUF) {
		this.nomeUF = nomeUF;
	}
	
	public String getSgUF() {
		return sgUF;
	}
	public void setSgUF(String sgUF) {
		this.sgUF = sgUF;
	}
	public long getIdUF() {
		return idUF;
	}
	public void setIdUF(long idUF) {
		this.idUF = idUF;
	}

}
