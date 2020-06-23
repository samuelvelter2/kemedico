package br.com.kemedico.utils;

import java.util.List;

import br.com.kemedico.model.Bairro;
import br.com.kemedico.model.Cidade;
import br.com.kemedico.model.Especializacao;
import br.com.kemedico.model.MeioPagamento;
import br.com.kemedico.model.PlanoSaude;

public class Pesquisa {
	private List<PlanoSaude> planos;
	private Cidade cidade;
	private List<Bairro> bairros;
	private Especializacao especialidade;
	private List<MeioPagamento> meios;
	private int cifroes;
	private String order;
	private String tipoPesquisa;
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Especializacao getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especializacao especialidade) {
		this.especialidade = especialidade;
	}
	
	public int getCifroes() {
		return cifroes;
	}
	public void setCifroes(int cifroes) {
		this.cifroes = cifroes;
	}
	public List<PlanoSaude> getPlanos() {
		return planos;
	}
	public void setPlanos(List<PlanoSaude> planos) {
		this.planos = planos;
	}
	public List<Bairro> getBairros() {
		return bairros;
	}
	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
	public List<MeioPagamento> getMeios() {
		return meios;
	}
	public void setMeios(List<MeioPagamento> meios) {
		this.meios = meios;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getTipoPesquisa() {
		return tipoPesquisa;
	}
	public void setTipoPesquisa(String tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}
}
