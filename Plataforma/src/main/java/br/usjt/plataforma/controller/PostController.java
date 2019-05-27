package br.usjt.plataforma.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.usjt.plataforma.model.bean.Post;
import br.usjt.plataforma.model.bean.Usuario;
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

	@GetMapping("adicionar")
	public ModelAndView adicionar(HttpSession httpSession) {

		ModelAndView mv = new ModelAndView("post");

		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");

		mv.addObject("usuario", usuario);

		mv.addObject("materiais", this.materialService.listar());

		mv.addObject("categorias", this.categoriaService.listar());

		mv.addObject("post", new Post());

		return mv;
	}

	@PostMapping
	public String salvar(Post post) {

		postService.salvar(post);

		return "redirect:/posts/resumo/" + post.getId();
	}

	@GetMapping("/resumo/{id}")
	public ModelAndView resumo(@PathVariable long id, HttpSession httpSession) {

		ModelAndView mv = new ModelAndView("resumo");

		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
		
		ArrayList<Post> posts = new ArrayList<Post>();
		
		posts.add(postService.get(id));

		mv.addObject("usuario", usuario);
		
		mv.addObject("postsDestaque", this.postService.listar());

		mv.addObject("categorias", this.categoriaService.listar());

		mv.addObject("posts", posts);

		return mv;
	}
	
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable long id, HttpSession httpSession) {

		ModelAndView mv = new ModelAndView("post_get");

		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
		
		ArrayList<Post> posts = new ArrayList<Post>();
		
		posts.add(postService.get(id));

		mv.addObject("usuario", usuario);
		
		mv.addObject("postsDestaque", this.postService.listar());

		mv.addObject("categorias", this.categoriaService.listar());

		mv.addObject("posts", posts);

		return mv;
	}
	
	

	@GetMapping()
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("post_listar");

		mv.addObject("posts", this.postService.listar());

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
