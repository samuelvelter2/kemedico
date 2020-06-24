package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PrecoCifrao {
	public PrecoCifrao(int cifroes, String faixaPrecos) {		
		this.cifroes = cifroes;
		this.faixaPrecos = faixaPrecos;
	}
	public PrecoCifrao() {
		super();
	}
	@Id	
	private int cifroes;	
	private String faixaPrecos;
	public int getCifroes() {
		return cifroes;
	}
	public void setCifroes(int cifroes) {
		this.cifroes = cifroes;
	}
	public String getFaixaPrecos() {
		return faixaPrecos;
	}
	public void setFaixaPrecos(String faixaPrecos) {
		this.faixaPrecos = faixaPrecos;
	}
	@Override
	public String toString() {
		return "PrecoCifrao [cifroes=" + cifroes + ", faixaPrecos=" + faixaPrecos + "]";
	}
}
