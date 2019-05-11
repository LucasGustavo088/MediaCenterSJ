package br.usjt.plataforma.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.plataforma.model.bean.Material;
import br.usjt.plataforma.service.CategoriaService;
import br.usjt.plataforma.service.MaterialService;
import br.usjt.plataforma.service.PostService;

@Controller
@RequestMapping("posts")
public class PostController {

	@Autowired
	PostService postService;

	@Autowired
	MaterialService materialService;
	
	@Autowired
	CategoriaService categoriaService;

	@GetMapping()
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("post");
		
		mv.addObject("materiais", this.materialService.listar());
		
		mv.addObject("categorias", this.categoriaService.listar());
		

		return mv;
	}
}
