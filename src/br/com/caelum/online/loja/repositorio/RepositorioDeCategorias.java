package br.com.caelum.online.loja.repositorio;

import java.util.List;

import br.com.caelum.online.loja.dominio.Categoria;
import br.com.caelum.online.loja.dominio.Produto;

public interface RepositorioDeCategorias {

	void salva(Categoria categoria);
	List<Categoria> pegaTodos();
	void remove(Produto produto);
	Categoria pegaPorId(int id);
}