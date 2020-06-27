package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bairro {
	
	public Bairro(long idBairro, String nomeBairro, Cidade cidade) {
		super();
		this.idBairro = idBairro;
		this.nomeBairro = nomeBairro;
		this.cidade = cidade;
	}
	public Bairro() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idBairro;
	private String nomeBairro;
	public Bairro(String nomeBairro, Cidade cidade) {
		super();
		this.nomeBairro = nomeBairro;
		this.cidade = cidade;
	}

	@ManyToOne
	private Cidade cidade;

	

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public long getIdBairro() {
		return idBairro;
	}
	public void setIdBairro(long idBairro) {
		this.idBairro = idBairro;
	}
	@Override
	public String toString() {
		return "Bairro [idBairro=" + idBairro + ", nomeBairro=" + nomeBairro + ", cidade=" + cidade + "]";
	}

}
