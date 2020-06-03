package br.com.kemedico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.bson.types.ObjectId;

@Entity
public class PlanoSaude {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	ObjectId id;
	String nomePlano;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Clinica> clinicas;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public List<Clinica> getClinicas() {
		return clinicas;
	}
	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}
	@Override
	public String toString() {
		return "PlanoSaude [id=" + id + ", nomePlano=" + nomePlano + ", clinicas=" + clinicas + "]";
	}
	
}
