package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.kemedico.model.PlanoSaude;

@Repository

public class PlanoSaudeDAO {
	@PersistenceContext
	private EntityManager entityManager;
	public void salva(PlanoSaude plano) {
		entityManager.persist(plano);
	}
	public List<PlanoSaude> lista(){
		return entityManager.createQuery("select Ps from PlanoSaude Ps", PlanoSaude.class).getResultList();
	}
}
