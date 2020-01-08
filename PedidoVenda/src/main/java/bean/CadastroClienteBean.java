package bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import model.Endereco;
import service.NegocioException;

@ManagedBean
public class CadastroClienteBean {

	private Endereco endereco;

	@PostConstruct
	public void init() {
		this.endereco = new Endereco();
	}

	public void salvar() {
		throw new RuntimeException();
		//throw new NegocioException("Método salvar ainda não foi implementado!");
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
