package br.com.kemedico.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private int estrelas;
	@ManyToOne
	private ProfissionalSaude profSaude;
	@ManyToOne
	private Clinica clinica;
	@ManyToOne
	private Paciente paciente;
	private LocalDateTime tempoAvaliacao;
	private String comentario;

	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
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

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", estrelas=" + estrelas + ", profSaude=" + profSaude + ", clinica=" + clinica
				+ ", paciente=" + paciente + ", tempoAvaliacao=" + tempoAvaliacao + ", comentario=" + comentario + "]";
	}

}
