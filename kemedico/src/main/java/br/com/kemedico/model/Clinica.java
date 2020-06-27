package br.com.kemedico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Clinica extends Usuario{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String cnpj;
	private String CEP;	
	@ManyToOne
	private Cidade cidade;
	@ManyToOne
	private Bairro bairro;
	private String numero;
	private String complemento;
	private String rua;
	private String numeroLocal;
	private String enderecoCompleto;
	private Boolean premium;
	@ManyToOne
	private PrecoCifrao cifroes;
	private String numeroFixo;
	@OneToOne
	private Foto fotoPerfil;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Foto> fotosClinica;	
	@OneToOne
	private ProfissionalSaude profResp;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<PlanoSaude> planos;	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<ProfissionalSaude> profissionaisSaude;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<MeioPagamento> meiosPagamento;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Especializacao> especialidades;
	private Double mediaAvaliada;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getNumeroLocal() {
		return numeroLocal;
	}
	public void setNumeroLocal(String numeroLocal) {
		this.numeroLocal = numeroLocal;
	}
	
	
	public List<ProfissionalSaude> getProfissionaisSaude() {
		return profissionaisSaude;
	}
	public void setProfissionaisSaude(List<ProfissionalSaude> profissionaisSaude) {
		this.profissionaisSaude = profissionaisSaude;
	}
	public ProfissionalSaude getProfResp() {
		return profResp;
	}
	public void setProfResp(ProfissionalSaude profResp) {
		this.profResp = profResp;
	}
	public List<PlanoSaude> getPlanos() {
		return planos;
	}
	public void setPlanos(List<PlanoSaude> planos) {
		this.planos = planos;
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
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<MeioPagamento> getMeiosPagamento() {
		return meiosPagamento;
	}
	public void setMeiosPagamento(List<MeioPagamento> meiosPagamento) {
		this.meiosPagamento = meiosPagamento;
	}
	public Boolean isPremium() {
		return premium;
	}
	public void setPremium(Boolean premium) {
		this.premium = premium;
	}
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Boolean getPremium() {
		return premium;
	}
	
	public Foto getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(Foto fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	public List<Foto> getFotosClinica() {
		return fotosClinica;
	}
	public void setFotosClinica(List<Foto> fotosClinica) {
		this.fotosClinica = fotosClinica;
	}
	public List<Especializacao> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<Especializacao> especialidades) {
		this.especialidades = especialidades;
	}
	public String getNumeroFixo() {
		return numeroFixo;
	}
	public void setNumeroFixo(String numeroFixo) {
		this.numeroFixo = numeroFixo;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}	
	public Clinica getAtualizado(Clinica cli) {
		if (this.cnpj == null) {
			this.cnpj = cli.getCnpj();
		}
		if (this.CEP == null) {
			this.CEP = cli.getCEP();
		}
		if (this.cidade == null) {
			this.cidade = cli.getCidade();
		}
		if (this.bairro == null) {
			this.bairro = cli.getBairro();
		}
		if (this.numero == null) {
			this.numero = cli.getNumero();
		}
		if (this.complemento == null) {
			this.complemento = cli.getComplemento();
		}
		if (this.rua == null) {
			this.rua = cli.getRua();
		}
		if (this.numeroLocal == null) {
			this.numeroLocal = cli.getNumeroLocal();
		}
		if (this.enderecoCompleto == null) {
			this.enderecoCompleto = cli.getEnderecoCompleto();
		}		
			this.premium = cli.isPremium();
		
		if (this.cifroes == null) {
			this.cifroes = cli.getCifroes();
		}
		if (this.numeroFixo == null) {
			this.numeroFixo = cli.getNumeroFixo();
		}
		if (this.fotoPerfil == null) {
			this.fotoPerfil = cli.getFotoPerfil();			
		}
		if (this.fotosClinica == null) {
			this.fotosClinica = cli.getFotosClinica();
		}
		if (this.profResp == null) {
			this.profResp = cli.getProfResp();
		}
		if (this.planos == null) {
			this.planos = cli.getPlanos();
		}
		if (this.profissionaisSaude == null) {
			this.profissionaisSaude = cli.getProfissionaisSaude();
		}
		if (this.meiosPagamento == null) {
			this.meiosPagamento = cli.getMeiosPagamento();
		}
		if (this.especialidades == null) {
			this.especialidades = cli.getEspecialidades();
		}
		super.getAtualizado(cli);
		
		return this;
	}
	public PrecoCifrao getCifroes() {
		return cifroes;
	}
	public void setCifroes(PrecoCifrao cifroes) {
		this.cifroes = cifroes;
	}
	@Override
	public String toString() {
		return "Clinica [cnpj=" + cnpj + ", CEP=" + CEP + ", cidade=" + cidade + ", bairro=" + bairro + ", numero="
				+ numero + ", complemento=" + complemento + ", rua=" + rua + ", numeroLocal=" + numeroLocal
				+ ", enderecoCompleto=" + enderecoCompleto + ", premium=" + premium + ", cifroes=" + cifroes
				+ ", numeroFixo=" + numeroFixo + ", fotoPerfil=" + fotoPerfil + ", fotosClinica=" + fotosClinica
				+ ", profResp=" + profResp + ", planos=" + planos + ", profissionaisSaude=" + profissionaisSaude
				+ ", meiosPagamento=" + meiosPagamento + ", especialidades=" + especialidades + super.toString()+ "]";
	}
	public Double getMediaAvaliada() {
		return mediaAvaliada;
	}
	public void setMediaAvaliada(Double mediaAvaliada) {
		this.mediaAvaliada = mediaAvaliada;
	}
	
	
}
