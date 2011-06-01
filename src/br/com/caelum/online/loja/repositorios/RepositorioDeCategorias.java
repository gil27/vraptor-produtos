package br.com.caelum.online.loja.repositorios;

import java.util.List;

import br.com.caelum.online.loja.dominio.Categoria;
import br.com.caelum.online.loja.dominio.Produto;

public interface RepositorioDeCategorias {

	public abstract void salva(Categoria categoria);

	public abstract List<Categoria> pegaTodos();

	public abstract void remove(Produto produto);

}