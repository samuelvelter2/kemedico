package br.com.kemedico.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.PlanoSaude;

@Repository
@Transactional
public class PlanoSaudeDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void salva(PlanoSaude plano) {
		entityManager.persist(plano);
	}

	public List<PlanoSaude> lista() {
		if (!HasAny()) {
			String[] nomePlanos = { "Cassi", "Quality", "IPASGO", "GEAP", "UNIMED", "Bradesco Saude" };
			for (int i = 0; i < nomePlanos.length; i++) {
				PlanoSaude ps = new PlanoSaude();
				ps.setNomePlano(nomePlanos[i]);
				salva(ps);
			}
		}
		return entityManager.createQuery("select Ps from PlanoSaude Ps", PlanoSaude.class).getResultList();
	}

	public PlanoSaude getPlano(String nome) {
		return entityManager.createQuery("select ps from PlanoSaude ps where nomePlano = :nome", PlanoSaude.class)
				.setParameter("nome", nome).getSingleResult();
	}

	public boolean HasAny() {
		try {
			entityManager.createQuery("from PlanoSaude", PlanoSaude.class).getResultList().get(0);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public List<PlanoSaude> getAllByIds(List<PlanoSaude> lista){
		ArrayList<PlanoSaude> list = new ArrayList<PlanoSaude>();
		for (int i = 0; i < lista.size(); i++) {
			list.add(getById(lista.get(i).getId()));
			
		}
		return list;
	}

	public PlanoSaude getById(Long id) {
		return entityManager.createQuery("from PlanoSaude where id = :id", PlanoSaude.class).setParameter("id", id)
				.getSingleResult();
	}
}
