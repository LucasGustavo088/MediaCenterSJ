package br.usjt.plataforma.repository;

import org.springframework.data.repository.CrudRepository;

import br.usjt.plataforma.model.bean.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

}
