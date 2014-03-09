package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dao.ProdutoDao;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class ProdutoController {
	
	private final ProdutoDao produtos;
	
	public ProdutoController(){
		this.produtos = new ProdutoDao();
	}
	
	public List<Produto> lista() {
		return produtos.pegaTodos();
	}
	
	@Path("/produto/{id}")
	public Produto exibe(long id){
		return produtos.pegaPorId(id);
	}
}