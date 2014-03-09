package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dao.ProdutoDao;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProdutoController {
	
	private final RepositorioDeProdutos produtos;
	public final Result result;
	
	public ProdutoController(RepositorioDeProdutos produtos, Result result){
		this.result = result;
		this.produtos = produtos;
	}
	
	public void formulario(){		
	}
	
	@Post
	public void adiciona(Produto produto){
		produtos.salva(produto);
		result.include("menssagem", "Produto adicionado com sucesso!");
		result.redirectTo(ProdutoController.class).lista();
	}
	
	public List<Produto> lista() {
		return produtos.pegaTodos();
	}
	
	@Path("/produto/{id}")
	public Produto exibe(long id){
		return produtos.pegaPorId(id);
	}
	
	@Path("/produto/{id}/xml")
	public void exibeComoXml(long id){
		Produto produto =  produtos.pegaPorId(id);
		result.use(Results.xml()).from(produto).serialize();
	}
}