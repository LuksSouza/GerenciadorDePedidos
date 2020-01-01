package model;

import java.math.BigDecimal;

public class Produto {

	private Integer sku;
	private String nome;
	private String categoria;
	private BigDecimal valorUnitario;
	private Integer estoque;

	public Produto(Integer sku, String nome, String categoria, BigDecimal valorUnitario, Integer estoque) {
		super();
		this.sku = sku;
		this.nome = nome;
		this.categoria = categoria;
		this.valorUnitario = valorUnitario;
		this.estoque = estoque;
	}

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

}
