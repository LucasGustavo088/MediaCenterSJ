package br.usjt.plataforma.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.usjt.plataforma.model.bean.Audio;
import br.usjt.plataforma.model.bean.Categoria;
import br.usjt.plataforma.model.bean.Figura;
import br.usjt.plataforma.model.bean.Texto;
import br.usjt.plataforma.model.bean.Usuario;
import br.usjt.plataforma.model.bean.Video;
import br.usjt.plataforma.repository.UsuarioRepository;
import br.usjt.plataforma.service.CategoriaService;
import br.usjt.plataforma.service.MaterialService;
import br.usjt.plataforma.service.TagService;
import br.usjt.plataforma.service.UsuarioService;
import br.usjt.plataforma.utils.Alerta;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(path = "/login")
	public ModelAndView login(HttpSession session) {
		
		
		ModelAndView mv = new ModelAndView("login");

		mv.addObject("usuario", new Usuario());
		//mv.addObject("alertas", session.get)
		return mv;
	}
	
	@PostMapping("/logar")
	public String logar(Usuario usuarioQueVeio, HttpSession httpSession) {
		
		
		if(usuarioService.logar(usuarioQueVeio)) {
			
			httpSession.setAttribute("logado", 1);
		    
			return "redirect:/";
		} else {
			
			Alerta.alerta("E-mail ou senhas incorretos.", "danger", httpSession);
			return "redirect:/login";
		}
	}
	
	@GetMapping(path = "/logout")
	public String logout(HttpSession httpSession) {
		
		httpSession.setAttribute("logado", 0);
		
		return "redirect:/login";
	}


}
