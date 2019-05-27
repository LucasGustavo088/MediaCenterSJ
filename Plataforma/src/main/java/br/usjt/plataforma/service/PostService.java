package br.usjt.plataforma.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.plataforma.model.bean.Avaliacao;
import br.usjt.plataforma.model.bean.Post;
import br.usjt.plataforma.repository.AvaliacaoRepository;
import br.usjt.plataforma.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository repository;
	
	private final AvaliacaoRepository avaliacaorepository;

	@Autowired
	public PostService(PostRepository postRepository, AvaliacaoRepository avaliacaoRepository) {

		this.repository = postRepository;
		this.avaliacaorepository = avaliacaoRepository;
	}

	public void salvar(Post post) {

		post.setDataRegistro(LocalDateTime.now());

		repository.save(post);
	}
	
	public Post get(long id) {

		return (Post) repository.findById(id);
	}

	public List<Post> listar() {

		return repository.findAllByOrderByDataRegistroDesc();

	}
	

	public List<Post> filtrar(String palavra) {

		return repository.filtrarPorNome(palavra);

	}
	
	public void avaliar(Avaliacao avaliacao) {
		
		avaliacaorepository.save(avaliacao);
	}

}
