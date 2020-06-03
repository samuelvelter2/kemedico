package br.com.kemedico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.bson.types.ObjectId;
@Entity
public class Clinica extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectId id;
	private String nomeClinica;
	private String cnpj;
	private String CEP;
	@ManyToOne
	private UF uf;
	@ManyToOne
	private Cidade cidade;
	@ManyToOne
	private Bairro bairro;
	private int numero;
	private String complemento;
	private String numeroLocal;
	private boolean premium;	
	@OneToOne
	private ProfissionalSaude profResp;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<PlanoSaude> planos;	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<ProfissionalSaude> profissionaisSaude;
	@ManyToMany
	private List<MeioPagamento> meiosPagamento;
	public String getNomeClinica() {
		return nomeClinica;
	}
	public void setNomeClinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;
	}
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
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
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
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
