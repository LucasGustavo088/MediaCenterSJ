package br.usjt.plataforma.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.usjt.plataforma.model.bean.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
	public List<Categoria> findAllByOrderByNomeAsc();

}
