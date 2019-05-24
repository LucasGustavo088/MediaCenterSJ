package br.usjt.plataforma.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.plataforma.model.bean.Usuario;
import br.usjt.plataforma.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository repository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {

		this.repository = usuarioRepository;
	}

	public Usuario login(Usuario usuario) {

		return this.repository.get(usuario.getEmail(), usuario.getSenha());

		/*
		 * if(!usuarios.isEmpty()) {
		 * 
		 * return true;
		 * 
		 * } else {
		 * 
		 * return false; }
		 */
	}

	public boolean estaAutenticado(HttpSession session) {
		int estalogado = (int) session.getAttribute("logado");
		if (estalogado == 1) {
			return true;
		} else {
			return false;
		}
	}

}
