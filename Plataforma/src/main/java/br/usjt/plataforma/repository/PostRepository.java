package br.usjt.plataforma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.usjt.plataforma.model.bean.Post;

public interface PostRepository extends CrudRepository<Post, Long>{
	
	public List<Post> findAllByOrderByDataRegistroDesc();
	
	@Query("SELECT p FROM Post p WHERE p.titulo LIKE %:palavra% ORDER BY data_registro DESC")
	public List<Post> filtrarPorNome(@Param("palavra") String palavra);


}
