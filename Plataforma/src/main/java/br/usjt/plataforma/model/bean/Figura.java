package br.usjt.plataforma.model.bean;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
@Table(name = "tb_figura")
public class Figura extends Material{
	
	private String autor;
	
	public Figura() {
		
		super();
	}
	
	public Figura(Long id, String nome, String url, String nomeoriginal, String tamanho, String autor) {
		
		super(id, nome, url, nomeoriginal, tamanho);
		
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Figura";
	}
	
	

}
