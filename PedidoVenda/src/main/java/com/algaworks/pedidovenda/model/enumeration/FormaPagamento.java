package com.algaworks.pedidovenda.model.enumeration;

public enum FormaPagamento {

    DINHEIRO("Dinheiro"),
    CARTAO_CREDITO("Cartao de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"),
    CHEQUE("Cheque"),
    BOLETO_BANCARIO("Boleto Bancário"),
    DEPOSITO_BANCARIO("Depósito Bancário");

    private String descricao;

    private FormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
