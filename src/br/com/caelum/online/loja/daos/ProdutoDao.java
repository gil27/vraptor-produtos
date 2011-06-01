package br.com.caelum.online.loja.daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorios.RepositorioDeProdutos;

public class ProdutoDao implements RepositorioDeProdutos {

	private static List<Produto> produtos;
	
	static {
		produtos = new ArrayList<Produto>();
	}
	
	public void salva(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> pegaTodos() {
		return Collections.unmodifiableList(produtos);
	}

	public void remove(Produto produto) {
		Iterator<Produto> it = produtos.iterator();
		while(it.hasNext()) {
			Produto existente = it.next();
			if(existente.getId() == produto.getId()) {
				it.remove();
				break;
			}
		}
	}

}
