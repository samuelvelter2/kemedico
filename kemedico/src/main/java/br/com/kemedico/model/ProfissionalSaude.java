package br.com.kemedico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProfissionalSaude")
public class ProfissionalSaude extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String crm;
	@ManyToOne
	private Especializacao especializacao1;
	@ManyToOne
	private Especializacao especializacao2;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Clinica> clinicas;
	@OneToOne
	private Foto fotoPerfil;
	private String CEP;
	@ManyToOne
	private UF uf;
	@ManyToOne
	private Cidade cidade;
	@ManyToOne
	private Bairro bairro;
	private int numero;
	private String complemento;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<PlanoSaude> planosParticular;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<MeioPagamento> meiosPagamento;
	private boolean premium;
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	public Foto getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(Foto fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public List<PlanoSaude> getPlanosParticular() {
		return planosParticular;
	}

	public void setPlanosParticular(List<PlanoSaude> planosParticular) {
		this.planosParticular = planosParticular;
	}

	public Especializacao getEspecializacao1() {
		return especializacao1;
	}

	public void setEspecializacao1(Especializacao especializacao1) {
		this.especializacao1 = especializacao1;
	}

	public Especializacao getEspecializacao2() {
		return especializacao2;
	}

	public void setEspecializacao2(Especializacao especializacao2) {
		this.especializacao2 = especializacao2;
	}

	public List<MeioPagamento> getMeiosPagamento() {
		return meiosPagamento;
	}

	public void setMeiosPagamento(List<MeioPagamento> meiosPagamento) {
		this.meiosPagamento = meiosPagamento;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

}
