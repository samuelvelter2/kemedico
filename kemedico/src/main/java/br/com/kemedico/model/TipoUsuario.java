package br.com.kemedico.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class TipoUsuario {
	@Id	
	private int codigo_tipo;
	private String desc_tipo;
	public int getCodigo_tipo() {
		return codigo_tipo;
	}
	public void setCodigo_tipo(int codigo_tipo) {
		this.codigo_tipo = codigo_tipo;
	}
	public String getDesc_tipo() {
		return desc_tipo;
	}
	public void setDesc_tipo(String desc_tipo) {
		this.desc_tipo = desc_tipo;
	}
}
