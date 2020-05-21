package br.com.kemedico.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Paciente")
public class Paciente extends Usuario {
	private String nomePaciente;
	private String sobreNome;
	private LocalDate dataNascimento;
	private String numeroCelular;
	private String cpf;

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nome) {
		this.nomePaciente = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getEmail() {
		return super.getEmail();
	}

	public void setEmail(String email) {
		super.setEmail(email);
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	@Override
	public String toString() {
		return "Paciente [" + super.toString() + "nome=" + nomePaciente + ", sobreNome=" + sobreNome
				+ ", dataNascimento=" + dataNascimento + ", numeroCelular=" + numeroCelular + ", cpf=" + cpf + ", rg="
				+ "]";
	}

}
