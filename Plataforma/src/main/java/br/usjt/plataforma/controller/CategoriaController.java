package br.usjt.plataforma.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.plataforma.model.bean.Categoria;
import br.usjt.plataforma.model.bean.Usuario;
import br.usjt.plataforma.service.CategoriaService;
import br.usjt.plataforma.service.PostService;
import br.usjt.plataforma.service.UsuarioService;

@Controller
@RequestMapping("categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PostService postService;

	@GetMapping
	public ModelAndView listar(HttpSession httpSession) {
			
		ModelAndView mv = new ModelAndView("categorias");
		
		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");

		mv.addObject("usuario", usuario);

		mv.addObject("categorias", this.categoriaService.listar());

		mv.addObject(new Categoria());

		return mv;
	}

	@PostMapping
	public String adicionar(Categoria categoria) {

		if (categoria.getNome() != null && !categoria.getNome().isEmpty()) {

			this.categoriaService.salvar(categoria);
		}

		return "redirect:/categorias";
	}

	@PostMapping("/atualizar")
	public String atualizar(@RequestParam("id") Long id, @RequestParam("nome") String nome) {

		if (nome != null && !nome.isEmpty()) {

			Categoria categoria = this.categoriaService.get(id);

			categoria.setNome(nome);

			this.categoriaService.salvar(categoria);
		}

		return "redirect:/categorias";
	}
	
	@GetMapping("/{id}")
	public ModelAndView filtrar(@PathVariable long id, HttpSession httpSession) {
				
		ModelAndView mv = new ModelAndView("categoria_listar");
		
		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");

		mv.addObject("usuario", usuario);
		
		mv.addObject("categoria", categoriaService.get(id));
		
		mv.addObject("categorias", this.categoriaService.listar());
		
		mv.addObject("posts", this.postService.listar());
		
		return mv;

	}

/*	@GetMapping(path = "editar/{id}")
	public void filtrar(@PathVariable("id") int id) {

		System.out.println("----->> " + id);
		
		

		//return "redirect:/categorias";
	}*/

}
