package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.bson.types.ObjectId;

@Entity
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId idCidade;
	private int codigoIBGE;
	@ManyToOne
	private UF ufCidade;
	private String nomeCidade;
	private String nomeComUF;

	public ObjectId getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(ObjectId idCidade) {
		this.idCidade = idCidade;
	}

	public int getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(int codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

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

}
