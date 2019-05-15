package br.usjt.plataforma.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.usjt.plataforma.model.bean.Post;

public interface PostRepository extends CrudRepository<Post, Long>{
	
	public List<Post> findAllByOrderByDataRegistroDesc();

}
