package br.usjt.plataforma.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.plataforma.model.bean.Categoria;
import br.usjt.plataforma.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaResource {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/{id}")
	public Categoria filtrar(@PathVariable long id) {
			
		Categoria categoria = categoriaService.get(id);
		
		System.out.println(categoria.getId());
		System.out.println(categoria.getNome());
		
		
		return categoria;

	}

}
