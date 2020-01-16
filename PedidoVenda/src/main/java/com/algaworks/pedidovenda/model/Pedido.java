package com.algaworks.pedidovenda.model;

import java.math.BigDecimal;
import java.util.Date;

import com.algaworks.pedidovenda.enumeration.StatusPedido;

public class Pedido {

	private Integer numero;
	private String cliente;
	private String vendedor;
	private Date dataCriacao;
	private BigDecimal valorTotal;
	private StatusPedido status;

	public Pedido(Integer numero, String cliente, String vendedor, Date dataCriacao, BigDecimal valorTotal,
			StatusPedido status) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.dataCriacao = dataCriacao;
		this.valorTotal = valorTotal;
		this.status = status;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

}
