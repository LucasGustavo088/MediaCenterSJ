package br.usjt.plataforma.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.plataforma.model.bean.Usuario;
import br.usjt.plataforma.service.PostService;

@Controller
public class IndexController {
	
	@Autowired
	PostService postService;

	@RequestMapping(value = {"/", "/index"})
	public ModelAndView index(Locale locale) {
		
		System.out.println(locale.toString());

		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("usuario", new Usuario());

		mv.addObject("posts", this.postService.listar());

		return mv;
	}

}
