package br.usjt.plataforma.model.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_material")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Material implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String url;

	private String nomeOriginal;

	private String tamanho;

	private LocalDateTime dataRegistro;

	private String tags;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "material_x_categoria", joinColumns = @JoinColumn(name = "id_material", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
	@JsonBackReference
	private List<Categoria> categorias = new ArrayList<>();

	public Material() {

		super();
	}

	public Material(Long id, String nome, String url, String nomeoriginal, String tamanho) {

		this.id = id;
		this.nome = nome;
		this.url = url;
		this.nomeOriginal = nomeoriginal;
		this.tamanho = tamanho;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNomeOriginal() {
		return nomeOriginal;
	}

	public void setNomeOriginal(String nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public abstract String toString();

}
