package br.com.kemedico.utils;

import java.util.List;

import br.com.kemedico.model.Avaliacao;

public class AvaliacaoMedia {
	private AvaliacaoMedia() {
		
	}
	public static Double getMediaAvaliada(List<Avaliacao> lista) {
		Double result = 0.0;
		for (int i = 0; i < lista.size(); i++) {
			result += lista.get(i).getEstrelas();
		}
		result /= lista.size();
		return result;
	}

}
