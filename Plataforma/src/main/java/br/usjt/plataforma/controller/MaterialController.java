package br.usjt.plataforma.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.plataforma.model.bean.Audio;
import br.usjt.plataforma.model.bean.Figura;
import br.usjt.plataforma.model.bean.Material;
import br.usjt.plataforma.model.bean.Texto;
import br.usjt.plataforma.model.bean.Video;
import br.usjt.plataforma.service.CategoriaService;
import br.usjt.plataforma.service.MaterialService;

@RestController
@Controller
@RequestMapping("materiais")
public class MaterialController {

	@Autowired
	MaterialService materialService;

	@Autowired
	CategoriaService categoriaService;

	@GetMapping()
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("materiais");

		mv.addObject("figura", new Figura());

		mv.addObject("texto", new Texto());

		mv.addObject("audio", new Audio());

		mv.addObject("video", new Video());

		mv.addObject("materiais", this.materialService.listar());

		mv.addObject("categorias", this.categoriaService.listar());

		return mv;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listarM() {

		List<JSONObject> entities = new ArrayList<JSONObject>();
		
		for (Material m : this.materialService.listar()) {
			JSONObject entity = new JSONObject();
			entity.put("nome", m.getNome());
			entity.put("url", m.getUrl());
			entities.add(entity);
		}
		
		return new ResponseEntity<Object>(entities.toString(), HttpStatus.OK);
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
