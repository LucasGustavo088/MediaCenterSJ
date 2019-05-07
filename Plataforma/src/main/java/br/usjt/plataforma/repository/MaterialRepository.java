package br.usjt.plataforma.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.usjt.plataforma.model.bean.Material;

public interface MaterialRepository extends CrudRepository<Material, Long> {

	public List<Material> findAllByOrderByDataRegistroDesc();
	
}
