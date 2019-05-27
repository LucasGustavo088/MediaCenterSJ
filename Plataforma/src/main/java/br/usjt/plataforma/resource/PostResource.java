package br.usjt.plataforma.resource;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.plataforma.model.bean.Avaliacao;
import br.usjt.plataforma.model.bean.Post;
import br.usjt.plataforma.model.bean.Usuario;
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
	
	@GetMapping("/avaliar/{idPost}/{nota}")
	public ResponseEntity avaliar(@PathVariable long idPost, @PathVariable double nota, HttpSession httpSession) {
		
		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
		
		System.out.println(usuario.getNome());
		
		System.out.println(idPost);
		System.out.println(nota);	
		
		Post post = new Post();
		
		post.setId(idPost);
		
		Avaliacao avaliacao = new Avaliacao(post, usuario, nota);
				
		this.postService.avaliar(avaliacao);
		
		return new ResponseEntity(HttpStatus.ACCEPTED);

	}

}
