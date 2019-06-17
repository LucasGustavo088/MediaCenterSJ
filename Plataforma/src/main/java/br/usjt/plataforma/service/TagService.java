package br.usjt.plataforma.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.plataforma.model.bean.Categoria;
import br.usjt.plataforma.model.bean.Material;
import br.usjt.plataforma.model.bean.Tag;
import br.usjt.plataforma.repository.TagRepository;

@Service
public class TagService {

	private final TagRepository repository;

	@Autowired
	public TagService(TagRepository tagRepository) {

		this.repository = tagRepository;
	}

	public List<Tag> listar() {

		return (ArrayList<Tag>) repository.findAll();

	}
	
	public void salvar(Tag tag) {
		
		tag.setDataRegistro(LocalDateTime.now());
		
		repository.save(tag);
	}
}
