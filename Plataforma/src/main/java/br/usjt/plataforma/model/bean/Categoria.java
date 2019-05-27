package br.usjt.plataforma.model.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true, length = 200)
	private String nome;

	private LocalDateTime dataRegistro;
	
	@ManyToMany(mappedBy = "categorias")
	@JsonManagedReference
	private List<Material> materiais = new ArrayList<>();
	
	@ManyToMany(mappedBy = "categorias")
	@JsonManagedReference
	private List<Post> posts = new ArrayList<>();

	
	public Categoria(String nome) {

		this.nome = nome;
	}

	public Categoria() {
	}

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

	
	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
	
	public List<Material> getMateriais() {
		return materiais;
	}
	
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
