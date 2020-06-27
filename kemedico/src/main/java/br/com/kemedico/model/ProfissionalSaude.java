package br.com.kemedico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Cidade cidade;
	@ManyToOne
	private Bairro bairro;
	private String rua;
	private String numero;
	private String complemento;
	private String nomeConsultorio;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<PlanoSaude> planosParticular;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<MeioPagamento> meiosPagamento;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Foto> fotosConsultorio;
	@ManyToOne
	private PrecoCifrao cifroes;
	private Double mediaAvaliada;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public List<Foto> getFotosConsultorio() {
		return fotosConsultorio;
	}

	public void setFotosConsultorio(List<Foto> fotosConsultorio) {
		this.fotosConsultorio = fotosConsultorio;
	}

	public String getNomeConsultorio() {
		return nomeConsultorio;
	}

	public void setNomeConsultorio(String nomeConsultorio) {
		this.nomeConsultorio = nomeConsultorio;
	}

	public void setCifroes(PrecoCifrao cifroes) {
		this.cifroes = cifroes;
	}

	public ProfissionalSaude getAtualizado(ProfissionalSaude prof) {
		if (this.crm == null) {
			this.crm = prof.getCrm();
		}
		if (this.especializacao1 == null) {
			this.especializacao1 = prof.getEspecializacao1();
		}
		if (this.clinicas == null) {
			this.clinicas = prof.getClinicas();
		}
		if (this.fotoPerfil == null) {
			this.fotoPerfil = prof.getFotoPerfil();
		}
		if (this.CEP == null) {
			this.CEP = prof.getCEP();
		}
		if (this.cidade == null) {
			this.cidade = prof.getCidade();
		}
		if (this.rua == null) {
			this.rua = prof.getRua();
		}
		if (this.numero == null) {
			this.numero = prof.getNumero();
		}
		if (this.complemento == null) {
			this.complemento = prof.getComplemento();
		}
		if (this.nomeConsultorio == null) {
			this.nomeConsultorio = prof.getNomeConsultorio();
		}
		if (this.planosParticular == null) {
			this.planosParticular = prof.getPlanosParticular();
		}
		if (this.meiosPagamento == null) {
			this.meiosPagamento = prof.getMeiosPagamento();
		}
		if (this.fotosConsultorio == null) {
			this.fotosConsultorio = prof.getFotosConsultorio();
		}
		if (this.cifroes == null) {
			this.cifroes = prof.getCifroes();
		}
		if (this.premium == false) {
			this.premium = prof.isPremium();
		}
		super.getAtualizado(prof);

		return this;

	}

	public PrecoCifrao getCifroes() {
		return cifroes;
	}

	public int getCifroesInt() {
		return cifroes.getCifroes();
	}

	public Double getMediaAvaliada() {
		return mediaAvaliada;
	}

	public void setMediaAvaliada(Double mediaAvaliada) {
		this.mediaAvaliada = mediaAvaliada;
	}

	@Override
	public String toString() {
		return "ProfissionalSaude [crm=" + crm + ", especializacao1=" + especializacao1 + ", especializacao2="
				+ especializacao2 + ", clinicas=" + clinicas + ", fotoPerfil=" + fotoPerfil + ", CEP=" + CEP
				+ ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero + ", complemento="
				+ complemento + ", nomeConsultorio=" + nomeConsultorio + ", planosParticular=" + planosParticular
				+ ", meiosPagamento=" + meiosPagamento + ", fotosConsultorio=" + fotosConsultorio + ", cifroes="
				+ cifroes + ", mediaAvaliada=" + mediaAvaliada + ", premium=" + premium + "]";
	}

}
