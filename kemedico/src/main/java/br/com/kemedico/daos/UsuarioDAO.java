package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.Usuario;
@Service
@Repository
@Transactional
public class UsuarioDAO implements UserDetailsService {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String chaveAcesso) throws UsernameNotFoundException {
		List<Usuario> usuarios = manager
				.createQuery("select u from Usuario u where email = :chaveAcesso OR numeroCpf = :chaveAcesso", Usuario.class)
				.setParameter("chaveAcesso", chaveAcesso).getResultList();
		if (usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return usuarios.get(0);
	}
	public boolean hasAny() {
		try {
			Usuario usuario = manager.createQuery("select u from Usuario u", Usuario.class).getResultList().get(0);
			usuario.toString();
		} catch (Exception e) {
			return false;
		}
		return true;		
	}
	
	public void salva(Usuario usuario) {
		manager.persist(usuario);
	}

}
