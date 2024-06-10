package com.generation.projetofarmacia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo NOME DA CATEGORIA é obrigatório!") 
	@Size(min = 3, max = 100, message = "O atributo NOME DA CATEGORIA deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nomecategoria;

	@NotBlank(message = "O atributo DESCRIÇÃO DA CATEGORIA é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo DESCRIÇÃO DA CATEGORIA deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String descricaocategoria;
	
	@NotBlank(message = "O atributo TIPO DE MEDICAMENTO é obrigatório!")
	@Size(min = 10, max = 100, message = "O atributo TIPO DE MEDICAMENTO deve conter no mínimo 10 e no máximo 100 caracteres")
	private String tipomedicamento;
	
	@NotBlank(message = "O atributo FABRICANTE é obrigatório!")
	@Size(min = 10, max = 100, message = "O atributo FABRICANTE deve conter no mínimo 10 e no máximo 100 caracteres")
	private String fabricante;
	
	@NotBlank(message = "O TIPO DE APRESENTAÇÃO do produto é obrigatório!")
	@Size(min = 3, max = 100, message = "O atributo TIPO DE APRESENTAÇÃO deve conter no mínimo 05 e no máximo 100 caracteres")
	private String tipoapresentação;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomecategoria() {
		return nomecategoria;
	}

	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
	}

	public String getDescricaocategoria() {
		return descricaocategoria;
	}

	public void setDescricaocategoria(String descricaocategoria) {
		this.descricaocategoria = descricaocategoria;
	}

	public String getTipomedicamento() {
		return tipomedicamento;
	}

	public void setTipomedicamento(String tipomedicamento) {
		this.tipomedicamento = tipomedicamento;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getTipoapresentação() {
		return tipoapresentação;
	}

	public void setTipoapresentação(String tipoapresentação) {
		this.tipoapresentação = tipoapresentação;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}