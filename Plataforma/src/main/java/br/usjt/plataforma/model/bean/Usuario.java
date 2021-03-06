package br.usjt.plataforma.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 200)
	private String nome;

	@Column(nullable = false, length = 200)
	private String senha;

	@Column(nullable = false, length = 30)
	private String fone;

	@Column(nullable = true, length = 100)
	private String email;

	private String papel;

	@OneToMany(mappedBy = "usuario")
	@JsonBackReference
	private List<Avaliacao> avaliacoes = new ArrayList<>();

	/*
	 * @OneToMany(mappedBy = "usuario") private List<TagSugerida> tagSugerida = new
	 * ArrayList<>();
	 */

	@OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
	@JsonBackReference
	private List<TagSugerida> tagSugeridas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public List<TagSugerida> getTagSugeridas() {
		return tagSugeridas;
	}

	public void setTagSugerida(List<TagSugerida> tagSugeridas) {
		this.tagSugeridas = tagSugeridas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", fone=" + fone + ", email=" + email
				+ ", papel=" + papel + "]";
	}

}
