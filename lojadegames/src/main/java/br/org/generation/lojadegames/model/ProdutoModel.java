package br.org.generation.lojadegames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {

	//atributos serão inseridos aqui:
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo é obrigatório")
	@Size(min = 3, max = 100, message = "O atributo deve conter mínimo 3 e máximo 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "O atributo é obrigatório")
	@Size(min = 2, max = 30, message = "O atributo deve conter mínimo 2 e máximo 30 caracter")
	private String console;
	
	@NotNull
	private int quantidade;
	
	@NotNull
	private BigDecimal preco;
	
	@Size(min = 5, max = 255, message = "O atributo deve conter mínimo 5 e máximo 255 caracteres")
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties ("produto")
	private CategoriaModel categoria;

	//Aqui se faz o encapsulamento:
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
}
