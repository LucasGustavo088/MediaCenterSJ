package br.usjt.plataforma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.usjt.plataforma.model.bean.Material;

public interface MaterialRepository extends CrudRepository<Material, Long> {

	public List<Material> findAllByOrderByDataRegistroDesc();
	
	@Query("SELECT m FROM Material m WHERE m.nome LIKE %:palavra% ORDER BY data_registro DESC")
	public List<Material> filtrarPorNome(@Param("palavra") String palavra);
	
}
