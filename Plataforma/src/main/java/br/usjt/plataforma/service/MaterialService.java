package br.usjt.plataforma.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.plataforma.model.bean.Material;
import br.usjt.plataforma.repository.MaterialRepository;

@Service
public class MaterialService {

	private final MaterialRepository repository;

	@Autowired
	public MaterialService(MaterialRepository materialRepository) {

		this.repository = materialRepository;
	}

	public void salvar(Material material) {

		material.setDataRegistro(LocalDateTime.now());		

		repository.save(material);
	}

	public List<Material> listar() {

		return (ArrayList<Material>) repository.findAllByOrderByDataRegistroDesc();

	}
	

}
