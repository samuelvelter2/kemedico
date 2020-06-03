package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import br.com.kemedico.model.Especializacao;

@Repository

public class EspecializacaoDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Especializacao> getEspecializacoes() {
		return entityManager.createQuery("select E from Especializacao E", Especializacao.class).getResultList();
	}

	public void salva(Especializacao esp) {
		entityManager.persist(esp);
	}

	public Especializacao getById(ObjectId id) {
		TypedQuery<Especializacao> query = entityManager
				.createQuery("select E from Especializacao E where E.idEsp = :id", Especializacao.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
