package com.algaworks.pedidovenda.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.algaworks.pedidovenda.enumeration.StatusPedido;
import com.algaworks.pedidovenda.model.Pedido;

@ManagedBean
public class PesquisaPedidoBean {

	private List<Pedido> pedidos;
	
	private StatusPedido orcamento;
	private StatusPedido emitido;
	private StatusPedido cancelado;
	
	@PostConstruct
	private void init() {
		this.pedidos = new ArrayList<Pedido>();
		
		Pedido pedido = new Pedido();//123, "Cliente Teste", "Vendedor Teste", new Date(), new BigDecimal(1250.56), StatusPedido.EMITIDO);
		
		for(int i = 0; i < 20; i++) {
			this.pedidos.add(pedido);
		}
	}

	public StatusPedido getOrcamento() {
		if (this.orcamento == null) this.orcamento = StatusPedido.ORCAMENTO;
		
		return orcamento;
	}

	public StatusPedido getEmitido() {
		if (this.emitido == null) this.emitido = StatusPedido.EMITIDO;
		
		return emitido;
	}

	public StatusPedido getCancelado() {
		if (this.cancelado == null) this.cancelado = StatusPedido.CANCELADO;
		
		return cancelado;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
}
