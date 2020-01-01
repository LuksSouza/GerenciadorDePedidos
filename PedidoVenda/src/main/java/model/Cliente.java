package model;

import enumeration.TipoCliente;

public class Cliente {

	private String nome;
	private TipoCliente tipo;
	private String cpfOrCnpj;
	private String email;

	public Cliente(String nome, TipoCliente tipo, String cpfOrCnpj, String email) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.cpfOrCnpj = cpfOrCnpj;
		this.email = email;
	}
	
	public Cliente() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
