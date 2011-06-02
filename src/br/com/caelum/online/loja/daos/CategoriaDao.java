package br.com.caelum.online.loja.daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.caelum.online.loja.dominio.Categoria;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorios.RepositorioDeCategorias;

public class CategoriaDao implements RepositorioDeCategorias {

	private static List<Categoria> categorias;
	
	static {
		populaCategoriasIniciais();
	}
	
	public void salva(Categoria categoria) {
		categorias.add(categoria);
	}

	public List<Categoria> pegaTodos() {
		return Collections.unmodifiableList(categorias);
	}

	public void remove(Produto produto) {
		Iterator<Categoria> it = categorias.iterator();
		while(it.hasNext()) {
			Categoria existente = it.next();
			if(existente.getId() == produto.getId()) {
				it.remove();
				break;
			}
		}
	}

	public Categoria pegaPorId(int id) {
		for(Categoria categoria : categorias) {
			if(categoria.getId() == id) return categoria;
		}
		return null;
	}
	
	private static void populaCategoriasIniciais() {
		categorias = new ArrayList<Categoria>();
		
		categorias.add(new Categoria(1, "Eletrônicos"));
		categorias.add(new Categoria(2, "Música"));
		categorias.add(new Categoria(3, "Perfumes"));
	}
	
}
