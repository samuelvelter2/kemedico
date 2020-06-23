package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cidade {

	public Cidade(UF ufCidade, String nomeCidade) {
		this.ufCidade = ufCidade;
		this.nomeCidade = nomeCidade;
		this.nomeComUF = nomeCidade + " - " + ufCidade.getSgUF();
	}

	public Cidade() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idCidade;
	@ManyToOne
	private UF ufCidade;
	private String nomeCidade;
	private String nomeComUF;

	

	public UF getUfCidade() {
		return ufCidade;
	}

	public void setUfCidade(UF ufCidade) {
		this.ufCidade = ufCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getNomeComUF() {
		return nomeComUF;
	}

	public void setNomeComUF(String nomeComUF) {
		this.nomeComUF = nomeComUF;
	}

	public long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(long idCidade) {
		this.idCidade = idCidade;
	}

}
