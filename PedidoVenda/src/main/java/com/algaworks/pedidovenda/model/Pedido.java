package com.algaworks.pedidovenda.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.algaworks.pedidovenda.enumeration.FormaPagamento;
import com.algaworks.pedidovenda.enumeration.StatusPedido;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataCriacao;
	private String observacao;
	private Date DataEntrega;
	private BigDecimal valorFrete;
	private BigDecimal valorDesconto;
	private BigDecimal valorTotal;
	private StatusPedido status;
	private FormaPagamento formaPagamento;
	private List<ItemPedido> itens;
	private Cliente cliente;
	private Usuario vendedor;
	private EnderecoEntrega enderecoEntrega;

}
