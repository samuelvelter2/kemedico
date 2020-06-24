package br.com.kemedico.enums;

public enum Tipo {
	SUCESSO("sucesso"),ERRO("erro"),INFO("info");
	private final String val;
	private Tipo(String val) {
		this.val = val;
	}
	public String getStatus() {
		return val;
	}
}
