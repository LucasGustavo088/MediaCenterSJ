package br.usjt.plataforma.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.usjt.plataforma.model.bean.Usuario;
import br.usjt.plataforma.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/login")
	public String login(Usuario usuario, HttpSession httpSession) {
		
		Usuario usuarioLogado = usuarioService.login(usuario);
		
		httpSession.setAttribute("usuario", usuarioLogado);
		
		System.out.println(usuarioLogado);		
					
		return "redirect:/perfil";
	

	/*	if (usuarioService.login(usuario)) {

			httpSession.setAttribute("usuario", usuario);

			return "redirect:/posts";
			
		} else {

			Alerta.alerta("E-mail ou senhas incorretos.", "danger", httpSession);
			return "redirect:/login";
		}*/
	}

	@GetMapping(path = "/logout")
	public String logout(HttpSession httpSession) {

		httpSession.setAttribute("logado", 0);

		return "redirect:/login";
	}

}
