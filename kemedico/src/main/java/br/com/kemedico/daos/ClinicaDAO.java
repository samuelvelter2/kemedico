package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.com.kemedico.model.Clinica;

@Repository

public class ClinicaDAO {
	@PersistenceContext
	EntityManager entityManager;

	public void salva(Clinica clinica) {
		entityManager.persist(clinica);
	}

	public List<Clinica> lista() {
		return entityManager.createQuery("select C from Clinica C", Clinica.class).getResultList();
	}
}
