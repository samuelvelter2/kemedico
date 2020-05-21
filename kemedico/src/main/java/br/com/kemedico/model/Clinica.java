package br.com.kemedico.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Clinica{
	@Id
	private int id;
	private String nomeClinica;
	private String cnpj;
	private String CEP;
	private String numeroLocal;
	private String cpfResp;
	@ManyToMany
	private List<ProfissionalSaude> profissionaisSaude;
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
	public String getCpfResp() {
		return cpfResp;
	}
	public void setCpfResp(String cpfResp) {
		this.cpfResp = cpfResp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ProfissionalSaude> getProfissionaisSaude() {
		return profissionaisSaude;
	}
	public void setProfissionaisSaude(List<ProfissionalSaude> profissionaisSaude) {
		this.profissionaisSaude = profissionaisSaude;
	}
	
}
