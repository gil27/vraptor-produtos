package br.com.caelum.online.loja.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;

public class ProdutoDao implements RepositorioDeProdutos {

	private static List<Produto> produtos;
	
	static {
		populaProdutosIniciais();
	}
	
	public void salva(Produto produto) {
		produto.setId(produtos.size() +1l);
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

	private static void populaProdutosIniciais() {
		
		produtos = new ArrayList<Produto>();
		produtos.add(new Produto(1, "iPod", "tocador de mp3 da apple", 299.90, eletronico));
		produtos.add(new Produto(1, "iPad", "tablet da apple", 1999.99, eletronico));
		produtos.add(new Produto(1, "212 for women", "perfume da carolina herrera", 67.80, perfume));
		produtos.add(new Produto(1, "Ivete Sangalo Ao Vivo", "cd da cantora", 29.90, musica));
	}

	public Produto pegaPorId(int id) {
		for(Produto produto : produtos) {
			if(produto.getId() == id) return produto;
		}
		return null;
	}

}
