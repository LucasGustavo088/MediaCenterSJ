package br.usjt.plataforma.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.usjt.plataforma.repository.AvaliacaoRepository;

public class AvaliacaoService {
	
private final AvaliacaoRepository repository;
	
	@Autowired
	public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
		
		this.repository = avaliacaoRepository;
	}
	
	

}
