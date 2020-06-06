package br.com.kemedico.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.kemedico.model.Paciente;

@Repository

public class PacienteDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void salva(Paciente paciente) {
		entityManager.persist(paciente);
	}
}