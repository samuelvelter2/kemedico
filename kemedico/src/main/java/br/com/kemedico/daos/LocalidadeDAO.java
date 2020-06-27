package br.com.kemedico.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.Bairro;
import br.com.kemedico.model.Cidade;
import br.com.kemedico.model.UF;

@Repository
@Transactional
public class LocalidadeDAO {
	@PersistenceContext
	EntityManager manager;

	public void salvaCidade(Cidade cd) {
		manager.persist(cd);
	}

	public void salvaBairro(Bairro br) {
		manager.persist(br);
	}

	public List<Cidade> getAllCidades() {
		if (!hasAnyUF()) {
			return null;
		}
		return manager.createQuery("select cd from Cidade cd", Cidade.class).getResultList();
	}

	public List<UF> getAllUF() {
		if (!hasAnyUF()) {
			String[] estados = { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
					"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará",
					"Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
					"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" };
			String[] siglas = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
					"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
			for (int i = 0; i < estados.length; i++) {
				manager.persist(new UF(estados[i], siglas[i]));
			}

		}
		return manager.createQuery("select uf from UF uf", UF.class).getResultList();
	}

	public boolean hasAnyUF() {
		try {
			manager.createQuery("select uf from UF uf", UF.class).getResultList().get(0);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean existsCidade(String nomeCidade, UF uf) {
		try {
			manager.createQuery("select cd from Cidade cd where nomeCidade = :nm_cd and ufCidade = :uf", Cidade.class)
					.setParameter("nm_cd", nomeCidade).setParameter("uf", uf).getResultList().get(0);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean existisBairro(String nomeBairro, Cidade cd) {
		try {
			manager.createQuery("select br from Bairro br where nomeBairro = :nomeBairro and cidade = :cidade",
					Bairro.class).setParameter("nomeBairro", nomeBairro).setParameter("cidade", cd).getResultList()
					.get(0);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Cidade getCidade(String nomeCidade, UF uf) {
		return manager
				.createQuery("select cd from Cidade cd where nomeCidade = :nm_cd and ufCidade = :uf", Cidade.class)
				.setParameter("nm_cd", nomeCidade).setParameter("uf", uf).getResultList().get(0);
	}

	public UF getUF(String sgUF) {
		if (!hasAnyUF()) {
			getAllUF();
		}
		return manager.createQuery("select uf from UF uf where sgUF = :sgUF", UF.class).setParameter("sgUF", sgUF)
				.getSingleResult();

	}

	public Bairro getBairro(String bairro, Cidade cidade) {
		return manager
				.createQuery("select br from Bairro br where cidade = :cidade and nomeBairro = :bairro", Bairro.class)
				.setParameter("cidade", cidade).setParameter("bairro", bairro).getResultList().get(0);
	}

	public Cidade createIfNotExistCidade(String cidade, String UF) {
		UF uf = getUF(UF);
		if (!existsCidade(cidade, uf)) {
			Cidade cd = new Cidade(getUF(UF), cidade);
			salvaCidade(cd);
			cd = getCidade(cidade, uf);
			return cd;
		}
		return getCidade(cidade, uf);
	}

	public Bairro createIfNotExistBairro(String bairro, String cidade, String UF) {
		UF uf = getUF(UF);
		Cidade cd = getCidade(cidade, uf);
		if (!existisBairro(bairro, cd)) {
			Bairro br = new Bairro(bairro, cd);
			salvaBairro(br);
			return getBairro(bairro, cd);
		}
		return getBairro(bairro, cd);
	}

	public Cidade getCidadeById(long id) {
		return manager.createQuery("from Cidade where idCidade = :id", Cidade.class).setParameter("id", id)
				.getSingleResult();
	}

	public List<Bairro> getBairrosByCidade(Cidade c) {
		return manager.createQuery("from Bairro where cidade = :cidade", Bairro.class).setParameter("cidade", c)
				.getResultList();
	}

	public Bairro getBairroById(Long id) {
		return manager.createQuery("from Bairro where idBairro = :id", Bairro.class).setParameter("id", id).getSingleResult();
	}

	public List<Bairro> getBairrosByIds(List<Bairro> lista) {
		ArrayList<Bairro> bairros = new ArrayList<Bairro>();
		if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {
				bairros.add(getBairroById(lista.get(i).getIdBairro()));
			}
		}
		return bairros;

	}

}
