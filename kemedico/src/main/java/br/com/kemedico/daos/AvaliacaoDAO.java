package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.Avaliacao;
import br.com.kemedico.model.Clinica;
import br.com.kemedico.model.ProfissionalSaude;

@Repository
@Transactional
public class AvaliacaoDAO {
	@PersistenceContext
	EntityManager manager;
	public void salva(Avaliacao av) {
		manager.persist(av);
		
	}	
	public List<Avaliacao> getAllByAvaliatedProfissionalSaude(ProfissionalSaude prof){
		return manager.createQuery("from Avaliacao where profSaude = :prof", Avaliacao.class).setParameter("prof",prof).getResultList();
	}
	public List<Avaliacao> getAllByAvaliatedClinica(Clinica cli){
		return manager.createQuery("from Avaliacao where clinica = :cli", Avaliacao.class).setParameter("cli",cli).getResultList();
	}
	public Avaliacao getAvaliacaoById(long id) {
		return manager.createQuery("from Avaliacao where id = :id", Avaliacao.class).setParameter("id", id).getSingleResult();
	}
	public List<Avaliacao> getAvaliacaoByPaciente(long id){
		return manager.createQuery("from Avaliacao where paciente.id = :id", Avaliacao.class).getResultList();
	}
}
