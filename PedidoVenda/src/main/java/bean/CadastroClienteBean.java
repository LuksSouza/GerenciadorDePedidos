package bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import model.Endereco;

@ManagedBean
public class CadastroClienteBean {

    private Endereco endereco;
    
    @PostConstruct
    public void init() {
	this.endereco = new Endereco();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
