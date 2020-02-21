package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.Produtos;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

    private static final long serialVersionUID = 4731009717164225956L;

    @Inject
    private Produtos produtos;

    @Transactional
    public Produto salvar(Produto produto) {

	if (produtos.porSKU(produto.getSku()) != null && produto.getId() == null) {
	    throw new NegocioException("Já existe produto cadastrado com o SKU informado");
	}

	return produtos.guardar(produto);
    }

}
