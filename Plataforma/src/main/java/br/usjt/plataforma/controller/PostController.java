package br.usjt.plataforma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.usjt.plataforma.model.bean.Post;
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
	public ModelAndView adicionar() {

		ModelAndView mv = new ModelAndView("post");

		mv.addObject("materiais", this.materialService.listar());

		mv.addObject("categorias", this.categoriaService.listar());

		mv.addObject("post", new Post());

		return mv;
	}

	@PostMapping
	public String salvar(Post post) {
		
		postService.salvar(post);

		/*postService.salvar(post);

		RedirectView redirectView = new RedirectView();

		redirectView.setUrl("/materiais/listar");

		return redirectView;*/
		
		return "redirect:/posts/listar";
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("post_listar");

		mv.addObject("posts", this.postService.listar());
		
		mv.addObject("materiais", this.materialService.listar());

		mv.addObject("categorias", this.categoriaService.listar());

		return mv;
	}

	
	@GetMapping("book")
	public ModelAndView book() {

		ModelAndView mv = new ModelAndView("book");

		mv.addObject("posts", this.postService.listar());
		
		mv.addObject("materiais", this.materialService.listar());

		mv.addObject("categorias", this.categoriaService.listar());

		return mv;
	}

}
