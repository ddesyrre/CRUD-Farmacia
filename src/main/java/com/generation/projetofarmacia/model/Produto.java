package com.generation.projetofarmacia.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank(message = "O atributo NOME é obrigatório!") 
	@Size(min = 3, max = 100, message = "O atributo NOME deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome;
	
    @Positive(message = "Forneça um valor válido e positivo!")
	private Integer estoque;
	
	@NotBlank(message = "O atributo DESCRIÇÃO é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo DESCRIÇÃO deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String descricao;
	
	@UpdateTimestamp
	private LocalDateTime datacadastro;
	
    @Positive(message = "Forneça um valor válido e positivo!")
	private float preco;
	
    @ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

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

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(LocalDateTime datacadastro) {
		this.datacadastro = datacadastro;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


}
	