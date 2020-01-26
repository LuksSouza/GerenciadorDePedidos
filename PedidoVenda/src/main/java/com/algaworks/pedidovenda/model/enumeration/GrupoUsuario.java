package com.algaworks.pedidovenda.model.enumeration;

import java.util.Arrays;
import java.util.List;

public enum GrupoUsuario {

    ADMINISTRADORES("Administradores"), AUXILIARES("Auxiliares"), VENDEDORES("Vendedores");

    private String descricao;

    private GrupoUsuario(String descricao) {
	this.descricao = descricao;
    }

    public String getDescricao() {
	return descricao;
    }

    public static List<GrupoUsuario> getGrupos() {
	return Arrays.asList(GrupoUsuario.ADMINISTRADORES, GrupoUsuario.AUXILIARES, GrupoUsuario.VENDEDORES);
    }
}
