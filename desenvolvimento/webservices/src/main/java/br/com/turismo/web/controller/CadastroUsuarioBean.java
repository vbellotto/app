package br.com.turismo.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.turismo.core.model.Usuario;
import br.com.turismo.core.repository.Usuarios;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	private Usuario usuario;

	private List<Usuario> todosUsuarios;

	public void inicializar() {
		usuario = new Usuario();
		todosUsuarios = usuarios.pesquisarTodosUsuarios();
	}

	public void cadastrar() {
		usuarios.cadastrar(usuario);
		inicializar();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getTodosUsuarios() {
		return todosUsuarios;
	}

	public void setTodosUsuarios(List<Usuario> todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}

}
