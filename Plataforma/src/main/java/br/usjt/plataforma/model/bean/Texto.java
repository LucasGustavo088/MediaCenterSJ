package br.usjt.plataforma.model.bean;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Table(name = "tb_texto")
public class Texto extends Material {

	private String resumo;

	public Texto() {

		super();
	}

	public Texto(Long id, String nome, String url, String nomeoriginal, String tamanho, String resumo) {

		super(id, nome, url, nomeoriginal, tamanho);

		this.resumo = resumo;

	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Texto";
	}

}
