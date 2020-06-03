package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import br.com.kemedico.model.ProfissionalSaude;

@Repository

public class ProfSaudeDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void salva(ProfissionalSaude saude) {
		entityManager.persist(saude);
	}

	public List<ProfissionalSaude> lista() {
		return entityManager.createQuery("select P from ProfissionalSaude P", ProfissionalSaude.class).getResultList();
	}

	public ProfissionalSaude getById(ObjectId id) {

		TypedQuery<ProfissionalSaude> query = entityManager
				.createQuery("select P from ProfissionalSaude P where P.id = :id", ProfissionalSaude.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
