package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.kemedico.model.Avaliacao;

@Repository
public class AvaliacaoDAO {
	@PersistenceContext
	EntityManager manager;
	public void salva(Avaliacao av) {
		manager.persist(av);
		
	}
	public List<Avaliacao> getAllByIdOfAvaliated(long id){
		return manager.createQuery("from Avaliacao where profSaude.id = :id OR clinica.id = :id", Avaliacao.class).setParameter("id", id).getResultList();
	}
	public Avaliacao getAvaliacaoById(long id) {
		return manager.createQuery("from Avaliacao where id = :id", Avaliacao.class).setParameter("id", id).getSingleResult();
	}
}
