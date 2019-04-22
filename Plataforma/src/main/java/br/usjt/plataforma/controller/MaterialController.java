package br.usjt.plataforma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.plataforma.model.bean.Audio;
import br.usjt.plataforma.model.bean.Figura;
import br.usjt.plataforma.model.bean.Texto;
import br.usjt.plataforma.model.bean.Video;
import br.usjt.plataforma.service.MaterialService;

@Controller
@RequestMapping("materiais")
public class MaterialController {

	@Autowired
	MaterialService materialService;
	
	@GetMapping()
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("materiais");
		
		mv.addObject("figura", new Figura());
		
		mv.addObject("texto", new Texto());
		
		mv.addObject("audio", new Audio());
		
		mv.addObject("video", new Video());
		
		mv.addObject("materiais", this.materialService.listar());

		return mv;
	}
	
	@PostMapping("figura")
	public String adicionarFigura(Figura figura) {

		if (figura.getNome() != null && !figura.getNome().isEmpty()) {

			this.materialService.salvar(figura);
		}
		
		return "redirect:/materiais";
	}
	
	@PostMapping("texto")
	public String adicionarTexto(Texto texto) {

		if (texto.getNome() != null && !texto.getNome().isEmpty()) {

			this.materialService.salvar(texto);
		}
		
		return "redirect:/materiais";
	}
	
	@PostMapping("audio")
	public String adicionarAudio(Audio audio) {

		if (audio.getNome() != null && !audio.getNome().isEmpty()) {

			this.materialService.salvar(audio);
		}
		
		return "redirect:/materiais";
	}
	
	@PostMapping("video")
	public String adicionarVideo(Video video) {

		if (video.getNome() != null && !video.getNome().isEmpty()) {

			this.materialService.salvar(video);
		}
		
		return "redirect:/materiais";
	}
	
}
