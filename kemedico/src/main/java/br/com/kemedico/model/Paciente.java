package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Paciente extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rg;
	@ManyToOne
	private UF estadoPaciente;
	
	private String apelido;
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}	

	public UF getEstadoPaciente() {
		return estadoPaciente;
	}

	public void setEstadoPaciente(UF estadoPaciente) {
		this.estadoPaciente = estadoPaciente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Paciente getAtualizado(Paciente pc) {
		if (this.estadoPaciente == null) {
			this.estadoPaciente = pc.getEstadoPaciente();			
		}
		if(this.rg == null) {
			this.rg = pc.getRg();
		}
		super.getAtualizado(pc);
		return this;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@Override
	public String toString() {
		return "Paciente [rg=" + rg + ", estadoPaciente=" + estadoPaciente + ", apelido=" + apelido + "]";
	}
}
