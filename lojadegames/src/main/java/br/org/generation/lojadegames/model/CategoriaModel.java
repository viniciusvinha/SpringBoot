package br.org.generation.lojadegames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_categoria")
public class CategoriaModel {

	//atributos serão colocados aqui:
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //esse seria o mesmo que o auto_increment
	private long id; 
	
	@NotNull
	@Size (min =3, max =30)
	private String descricao;
	
	@NotBlank(message = "O atributo é obrigatório")
	@Size(min = 5, max = 255, message = "O atributo deve conter mínimo 5 e máximo 255 caracter")
	private String tipo;
	
	//Aqui serve para mantermos a integridade da informação
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("categoria")
	private List<ProdutoModel> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}
	
	//Aqui faremos o encapsulamento:
	
	
}
