package br.usjt.plataforma.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.plataforma.model.bean.Post;
import br.usjt.plataforma.model.bean.Usuario;
import br.usjt.plataforma.repository.PostRepository;
import br.usjt.plataforma.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	
	private final UsuarioRepository repository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		
		this.repository = usuarioRepository;
	}
	
	public boolean logar(Usuario usuario) {
		
		List <Usuario> usuarios = this.repository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
		if(!usuarios.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean estaAutenticado(HttpSession session) {
		int estalogado = (int) session.getAttribute("logado");
		if(estalogado == 1) {
			return true;
		} else {
			return false;
		}
	}

}
