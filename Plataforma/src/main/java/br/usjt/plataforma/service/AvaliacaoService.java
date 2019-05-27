package br.usjt.plataforma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.plataforma.model.bean.Avaliacao;
import br.usjt.plataforma.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	
private final AvaliacaoRepository repository;
	
	@Autowired
	public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
		
		this.repository = avaliacaoRepository;
	}
	
	public List<Avaliacao> listar() {

		return (List<Avaliacao>) repository.findAll();

	}
	
	

}
