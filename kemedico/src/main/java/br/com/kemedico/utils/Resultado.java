package br.com.kemedico.utils;

import java.util.List;

public class Resultado<E> {
	private List<E> resultados;
	private int qtResultados;
	private int qtTotal;
	public List<E> getResultados() {
		return resultados;
	}
	public void setResultados(List<E> resultados) {
		this.resultados = resultados;
	}
	public int getQtResultados() {
		return qtResultados;
	}
	public void setQtResultados(int qtResultados) {
		this.qtResultados = qtResultados;
	}
	public int getQtTotal() {
		return qtTotal;
	}
	public void setQtTotal(int qtTotal) {
		this.qtTotal = qtTotal;
	}
	@Override
	public String toString() {
		return "Resultado [resultados=" + resultados + ", qtResultados=" + qtResultados + ", qtTotal=" + qtTotal + "]";
	}
	
}
