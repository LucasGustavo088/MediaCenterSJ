package br.usjt.plataforma.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.plataforma.model.bean.Usuario;
import br.usjt.plataforma.service.CategoriaService;
import br.usjt.plataforma.service.PostService;

@Controller
@RequestMapping("perfil")
public class PerfilController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	CategoriaService categoriaService;

	@GetMapping()
	public ModelAndView perfil(HttpSession httpSession) {

		ModelAndView mv = new ModelAndView();

		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");

		mv.addObject("usuario", usuario);
		
		mv.addObject("posts", this.postService.listar());
		
		mv.addObject("categorias", this.categoriaService.listar());

		if (usuario.getPapel().equals("Administrador")) {
			
			mv.setViewName("dashBoard");

		} else if (usuario.getPapel().equals("Usuario")) {
			
			mv.setViewName("timeLine");

		} else {

			throw new RuntimeException();
		}

		return mv;
	}

}
