package br.com.caelum.online.loja.daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.caelum.online.loja.dominio.Categoria;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorios.RepositorioDeProdutos;

public class ProdutoDao implements RepositorioDeProdutos {

	private static List<Produto> produtos;
	
	static {
		populaProdutosIniciais();
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

	private static void populaProdutosIniciais() {
		Categoria eletronico = new Categoria(1, "Eletrônicos");
		Categoria musica = new Categoria(2, "Música");
		Categoria perfume = new Categoria(3, "Perfumes");
		
		produtos = new ArrayList<Produto>();
		produtos.add(new Produto(1, "iPod", "tocador de mp3 da apple", 299.90, eletronico));
		produtos.add(new Produto(1, "iPad", "tablet da apple", 1999.99, eletronico));
		produtos.add(new Produto(1, "212 for women", "perfume da carolina herrera", 67.80, perfume));
		produtos.add(new Produto(1, "Ivete Sangalo Ao Vivo", "cd da cantora baiana", 29.90, musica));
	}

	public Produto pegaPorId(int id) {
		for(Produto produto : produtos) {
			if(produto.getId() == id) return produto;
		}
		return null;
	}

}
