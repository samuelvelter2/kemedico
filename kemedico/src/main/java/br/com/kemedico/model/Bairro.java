package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;

@Entity
public class Bairro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId idBairro;
	private String nomeBairro;

	public ObjectId getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(ObjectId idBairro) {
		this.idBairro = idBairro;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

}
