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

	/*@GetMapping(path = "adicionar/{fileName}")
	public ModelAndView adicionar(@PathVariable("fileName") String fileName) {

		String mime = (fileName.split("\\."))[1].toLowerCase().trim();

		System.out.println(mime);

		ModelAndView mv = new ModelAndView();

		if (mime.equals("jpg")) {

			mv.setViewName("adicionar_figura");

			Figura figura = new Figura();

			figura.setUrl(fileName);

			mv.addObject(figura);

		} else if (mime.equals("pdf")) {

			mv.setViewName("adicionar_texto");

			Texto texto = new Texto();

			texto.setUrl(fileName);

			mv.addObject(texto);

		} else if (mime.equals("mp4")) {

			mv.setViewName("adicionar_video");

			Video video = new Video();

			video.setUrl(fileName);

			mv.addObject(video);

		} else if (mime.equals("mp3")) {

			mv.setViewName("adicionar_audio");

			Audio audio = new Audio();

			audio.setUrl(fileName);

			mv.addObject(audio);

		} else {

			mv.setViewName("aff");

		}

		return mv;

	}*/

//	@PostMapping("adicionar/figura")
//	public String adicionar(Figura figura) {
//
//		if (figura.getNome() != null && !figura.getNome().isEmpty()) {
//
//			this.materialService.salvar(figura);
//		}
//		
//		return "redirect:/figuras";
//	}

}
