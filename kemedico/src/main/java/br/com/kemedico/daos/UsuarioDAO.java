package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.kemedico.model.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String chaveAcesso) throws UsernameNotFoundException {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :chaveAcesso OR cpf = :chaveAcesso", Usuario.class).getResultList();
		if (usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return usuarios.get(0);
	}
	
}
