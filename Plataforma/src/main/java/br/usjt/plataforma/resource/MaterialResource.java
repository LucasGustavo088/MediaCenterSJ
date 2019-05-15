package br.usjt.plataforma.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.plataforma.model.bean.Material;
import br.usjt.plataforma.service.MaterialService;

@RestController
@RequestMapping("/api/materiais")
public class MaterialResource {
	
	@Autowired
	MaterialService materialService;
	
	@GetMapping("/filtrar/{palavra}")
	public List<Material> filtrar(@PathVariable String palavra) {
		
		System.out.println(palavra);
		
		return materialService.filtrar(palavra);

	}

}
