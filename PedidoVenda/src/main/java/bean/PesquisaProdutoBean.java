package bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import model.Produto;

@ManagedBean
public class PesquisaProdutoBean {
	
	private List<Produto> produtos;
	
	@PostConstruct
	private void init() {
		produtos = new ArrayList<Produto>();
		
		Produto produto = new Produto(123, "Bala de morango", "Doces", new BigDecimal(1.50), 98);
		
		for (int i = 0; i < 20; i++) {
			this.produtos.add(produto);
		}
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
