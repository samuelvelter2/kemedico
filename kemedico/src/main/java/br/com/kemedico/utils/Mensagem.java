package br.com.kemedico.utils;

import br.com.kemedico.enums.Tipo;

public class Mensagem {
	private String texto;
	private Tipo tipo;
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Mensagem(String texto, Tipo tipo) {		
		this.texto = texto;
		this.tipo = tipo;
	}
}
