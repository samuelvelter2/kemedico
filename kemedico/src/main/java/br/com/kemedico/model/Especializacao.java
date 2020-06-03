package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;

@Entity
public class Especializacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId idEsp;
	private String descEsp;
	
	
	public ObjectId getIdEsp() {
		return idEsp;
	}
	public void setIdEsp(ObjectId idEsp) {
		this.idEsp = idEsp;
	}
	public String getDescEsp() {
		return descEsp;
	}
	public void setDescEsp(String descEsp) {
		this.descEsp = descEsp;
	}
	@Override
	public String toString() {
		return "Especializacao [idEsp=" + idEsp.toString() + ", descEsp=" + descEsp + "]";
	}
	
	
	
	
}
