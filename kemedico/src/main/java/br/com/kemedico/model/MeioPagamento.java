package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;
@Entity
public class MeioPagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId idMeio;
	private String descMeio;
	public ObjectId getIdMeio() {
		return idMeio;
	}
	public void setIdMeio(ObjectId idMeio) {
		this.idMeio = idMeio;
	}
	public String getDescMeio() {
		return descMeio;
	}
	public void setDescMeio(String descMeio) {
		this.descMeio = descMeio;
	}
	
}
