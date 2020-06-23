package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class MeioPagamento {
	
	public MeioPagamento(String descMeio) {
		super();
		this.descMeio = descMeio;
	}
	public MeioPagamento() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idMeio;
	private String descMeio;
	public long getIdMeio() {
		return idMeio;
	}
	public void setIdMeio(long idMeio) {
		this.idMeio = idMeio;
	}
	public String getDescMeio() {
		return descMeio;
	}
	public void setDescMeio(String descMeio) {
		this.descMeio = descMeio;
	}
	@Override
	public String toString() {
		return "MeioPagamento [idMeio=" + idMeio + ", descMeio=" + descMeio + "]";
	}
	
}
