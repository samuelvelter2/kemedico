package br.com.kemedico.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.Paciente;

@Repository
@Transactional
public class PacienteDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void salva(Paciente paciente) {
		entityManager.persist(paciente);
	}
	public Paciente getById(long id) {
		return entityManager.createQuery("from Paciente where id = :id", Paciente.class).setParameter("id", id).getSingleResult();		
	}
	public void update(Paciente p) {
		entityManager.merge(p);
	}
}
