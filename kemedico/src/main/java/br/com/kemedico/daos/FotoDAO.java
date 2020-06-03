package br.com.kemedico.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.com.kemedico.model.Foto;

@Repository

public class FotoDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void salva(Foto foto) {
		entityManager.persist(foto);
	}
}
