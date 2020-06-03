package br.com.kemedico.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.bson.types.ObjectId;

@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;
	private double estrelas;
	@ManyToOne
	private ProfissionalSaude profSaude;
	@ManyToOne
	private Paciente paciente;
	private LocalDateTime tempoAvaliacao;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public double getEstrelas() {
		return estrelas;
	}
	public void setEstrelas(double estrelas) {
		this.estrelas = estrelas;
	}
	public ProfissionalSaude getProfSaude() {
		return profSaude;
	}
	public void setProfSaude(ProfissionalSaude profSaude) {
		this.profSaude = profSaude;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public LocalDateTime getTempoAvaliacao() {
		return tempoAvaliacao;
	}
	public void setTempoAvaliacao(LocalDateTime tempoAvaliacao) {
		this.tempoAvaliacao = tempoAvaliacao;
	}
	
}
