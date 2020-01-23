package com.algaworks.pedidovenda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CNPJ;

import com.algaworks.pedidovenda.enumeration.TipoPessoa;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 214124584609308286L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome deve ser informado")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull
    @Email
    @Column(nullable = false, length = 255)
    private String email;

    @NotNull
    @CNPJ
    @Column(name = "doc_receita_federal", nullable = false, length = 14)
    private String documentoReceitaFederal;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    public Cliente(Long id, String nome, String email, String documentoReceitaFederal, TipoPessoa tipo) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.documentoReceitaFederal = documentoReceitaFederal;
	this.tipo = tipo;
    }

    public Cliente() {
    }

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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getDocumentoReceitaFederal() {
	return documentoReceitaFederal;
    }

    public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
	this.documentoReceitaFederal = documentoReceitaFederal;
    }

    public TipoPessoa getTipo() {
	return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
	this.tipo = tipo;
    }

    public List<Endereco> getEnderecos() {
	return enderecos;
    }
    
    public void addEndereco(Endereco endereco) {
	this.enderecos.add(endereco);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Cliente other = (Cliente) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", documentoReceitaFederal=" + documentoReceitaFederal
		+ ", tipo=" + tipo + ", enderecos=" + enderecos + "]";
    }

}
