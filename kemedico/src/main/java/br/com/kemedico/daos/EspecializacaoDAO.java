package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.Especializacao;

@Repository
@Transactional
public class EspecializacaoDAO {
	@PersistenceContext
	private EntityManager entityManager;	

	public void salva(Especializacao esp) {
		entityManager.persist(esp);
	}

	public Especializacao getById(long id) {
		TypedQuery<Especializacao> query = entityManager
				.createQuery("select E from Especializacao E where E.idEsp = :id", Especializacao.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	public boolean HasAny() {
		try {
			entityManager.createQuery("select e from Especializacao e", Especializacao.class).getResultList().get(0);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public List<Especializacao> getAll(){
		if(!HasAny()) {
			String[] nomeEsp = {"Anestesiologista",
					"Clínica médica",
					"Dermatologista",
					"Cardiologista",
					"Pscicólogo",
					"Ginecologista",
					"Homeopatia",
					"Pediatra",
					"Endocrinologista",
					"Infectologista",
					"Dentista",
					"Neurocirurgista",
					"Oncologista",
					"Nutrologista",
					"Geriatra",
					"Neurologista",
					"Oftalmologista",
					"Ortopedista",
					"Otorrinolaringologista",
					"Fisioterapeuta"};
			for (int i = 0; i < nomeEsp.length; i++) {
				salva(new Especializacao(nomeEsp[i]));
			}			
		}
		return entityManager.createQuery("select e from Especializacao e", Especializacao.class).getResultList();
	}
}
