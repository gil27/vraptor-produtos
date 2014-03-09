package br.com.caelum.online.loja.controlador;

import br.com.caelum.online.loja.dominio.UsuarioLogado;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class LoginController {
	
	public final UsuarioLogado usuarioLogado;
	private final Result result;
	
	public LoginController(UsuarioLogado usuarioLogado, Result result){
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	public void loga(){
		usuarioLogado.setLogin("Caelum");
	}
	public void exibe(){
		result.include("usuario", usuarioLogado.getLogin());
	}
}
