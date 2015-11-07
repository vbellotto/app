package br.com.turismo.core.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.turismo.core.model.Usuario;
import br.com.turismo.core.util.jpa.Transactional;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void cadastrar(Usuario usuario) {
		manager.persist(usuario);
	}

	public Usuario gravar(Usuario usuario) {
		return manager.merge(usuario);
	}

	public List<Usuario> pesquisarTodosUsuarios() {
		return manager.createQuery("from Usuario order by nome", Usuario.class)
				.getResultList();
	}

	public Usuario pesquisarPorEmail(String email) {
		try {
			return manager
					.createQuery("from Usuario where email = :email",
							Usuario.class).setParameter("email", email)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuario pesquisarPorEmailSenha(String email, String senha) {
		try {
			return manager
					.createQuery(
							"from Usuario where email = :email and senha = :senha",
							Usuario.class).setParameter("email", email)
					.setParameter("senha", senha).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
