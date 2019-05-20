package br.usjt.plataforma.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.usjt.plataforma.model.bean.Audio;
import br.usjt.plataforma.model.bean.Figura;
import br.usjt.plataforma.model.bean.Texto;
import br.usjt.plataforma.model.bean.Video;
import br.usjt.plataforma.service.CategoriaService;
import br.usjt.plataforma.service.MaterialService;
import br.usjt.plataforma.service.UsuarioService;




@Controller
@RequestMapping("materiais")
public class MaterialController {

	@Autowired
	MaterialService materialService;

	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	//TagService tagService;

	@GetMapping()
	public ModelAndView listar(HttpSession session) {

		ModelAndView mv = new ModelAndView("materiais");

		mv.addObject("figura", new Figura());

		mv.addObject("texto", new Texto());

		mv.addObject("audio", new Audio());

		mv.addObject("video", new Video());

		mv.addObject("materiais", this.materialService.listar());

		mv.addObject("categorias", this.categoriaService.listar());

		//mv.addObject("tags", this.tagService.listar());

		return mv;
	}

	@PostMapping("figura")
	public RedirectView adicionarFigura(Figura figura) {

		if (figura.getNome() != null && !figura.getNome().isEmpty()) {

			this.materialService.salvar(figura);
		}

		RedirectView redirectView = new RedirectView();

		redirectView.setUrl("/materiais");

		return redirectView;

	}

	@PostMapping("texto")
	public RedirectView adicionarTexto(Texto texto) {

		if (texto.getNome() != null && !texto.getNome().isEmpty()) {

			this.materialService.salvar(texto);
		}

		RedirectView redirectView = new RedirectView();

		redirectView.setUrl("/materiais");

		return redirectView;
	}

	@PostMapping("audio")
	public RedirectView adicionarAudio(Audio audio) {

		if (audio.getNome() != null && !audio.getNome().isEmpty()) {

			this.materialService.salvar(audio);
		}

		RedirectView redirectView = new RedirectView();

		redirectView.setUrl("/materiais");

		return redirectView;
	}

	@PostMapping("video")
	public RedirectView adicionarVideo(Video video) {

		if (video.getNome() != null && !video.getNome().isEmpty()) {

			this.materialService.salvar(video);
		}

		RedirectView redirectView = new RedirectView();

		redirectView.setUrl("/materiais");

		return redirectView;
	}

	
}
