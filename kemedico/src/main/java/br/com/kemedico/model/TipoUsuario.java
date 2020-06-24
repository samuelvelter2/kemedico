package br.com.kemedico.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class TipoUsuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TipoUsuario(String desc_tipo) {		
		this.desc_tipo = desc_tipo;
	}
	public TipoUsuario() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long cod_tipo;
	private String desc_tipo;	
	public String getDesc_tipo() {
		return desc_tipo;
	}
	public void setDesc_tipo(String desc_tipo) {
		this.desc_tipo = desc_tipo;
	}	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
