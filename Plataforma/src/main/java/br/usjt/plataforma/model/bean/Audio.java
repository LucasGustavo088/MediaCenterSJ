package br.usjt.plataforma.model.bean;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Table(name = "tb_audio")
public class Audio extends Material {

	private String duracao;

	public Audio() {

		super();
	}

	public Audio(Long id, String nome, String url, String nomeoriginal, String tamanho, String duracao) {

		super(id, nome, url, nomeoriginal, tamanho);

		this.duracao = duracao;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Audio";
	}

}
