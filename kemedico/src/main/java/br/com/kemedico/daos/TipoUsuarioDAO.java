package br.com.kemedico.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.TipoUsuario;

@Repository
@Transactional
public class TipoUsuarioDAO {
	@PersistenceContext
	EntityManager manager;

	
	public void salva(TipoUsuario usuario) {
		manager.persist(usuario);
	}

	public boolean hasAny() {
		try {
			TipoUsuario usuario = manager.createQuery("select t from TipoUsuario t", TipoUsuario.class).getResultList()
					.get(0);
			usuario.toString();
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public TipoUsuario getByDesc(String desc) {
		if (!hasAny()) {
			String[] descb = { "Paciente", "ProfSaude", "Clinica", "Administrador" };
			for (int i = 0; i < descb.length; i++) {
				salva(new TipoUsuario(descb[i]));
			}
		}
		TypedQuery<TipoUsuario> query = manager.createQuery("select t from TipoUsuario t where desc_tipo = :desc",
				TipoUsuario.class);
		query.setParameter("desc", desc);
		return query.getSingleResult();

	}
}
