package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.Role;

@Repository
@Transactional
public class RoleDAO {
	@PersistenceContext
	EntityManager manager;
	
	public void salva(Role role) {
		manager.persist(role);
	}
	public Role getRole(String nome) {
		createRoles();
		TypedQuery<Role> query = manager.createQuery("select r from Role r where nome = :nome", Role.class);
		query.setParameter("nome", nome);
		return query.getSingleResult();
	}
	public List<Role> getAll(){
		TypedQuery<Role> query = manager.createQuery("select r from Role r", Role.class);
		return query.getResultList();
	}
	public boolean hasAny() {
		try {
			Role role = manager.createQuery("select t from Role t", Role.class).getResultList().get(0);
			role.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}
	public void createRoles() {
		if (!hasAny()) {
			salva(new Role("ROLE_ADMIN"));
			salva(new Role("ROLE_CLINICA"));
			salva(new Role("ROLE_PROFSAU"));
			salva(new Role("ROLE_USER"));
		}
	}

}
