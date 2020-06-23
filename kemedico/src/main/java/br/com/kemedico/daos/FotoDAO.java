package br.com.kemedico.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.Foto;

@Repository
@Transactional
public class FotoDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void salva(Foto foto) {
		entityManager.persist(foto);
	}
	public Foto getById(long id) {
		return entityManager.createQuery("from Foto where idFoto = :id", Foto.class).setParameter("id", id).getSingleResult();
	}
	public void update(Foto foto) {
		entityManager.merge(foto);
	}
}
