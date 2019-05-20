package br.usjt.plataforma.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.plataforma.model.bean.Post;
import br.usjt.plataforma.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostResource {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/filtrar/{palavra}")
	public List<Post> filtrar(@PathVariable String palavra) {
		
		System.out.println(palavra);
		
		return postService.filtrar(palavra);

	}

}
