package br.usjt.plataforma.service;

import java.time.LocalDateTime;
<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.plataforma.model.bean.Post;
import br.usjt.plataforma.repository.PostRepository;

@Service
public class PostService {
	
	private final PostRepository repository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		
		this.repository = postRepository;
	}
	
	public void salvar(Post post) {
		
		post.setDataRegistro(LocalDateTime.now());
		
		repository.save(post);
	}
	
	public List<Post> listar() {

		return repository.findAllByOrderByDataRegistroDesc();

	}
	
	public List<Post> filtrar(String palavra) {

		return repository.filtrarPorNome(palavra);
=======
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.plataforma.model.bean.Post;
import br.usjt.plataforma.repository.PostRepository;

@Service
public class PostService {
	
	private final PostRepository repository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		
		this.repository = postRepository;
	}
	
	public void salvar(Post post) {
		
		post.setDataRegistro(LocalDateTime.now());
		
		repository.save(post);
	}
	
	public List<Post> listar() {

		return repository.findAllByOrderByDataRegistroDesc();
>>>>>>> refs/remotes/origin/internacionalizacao

	}

}
