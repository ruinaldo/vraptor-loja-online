package br.com.loja.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.loja.modelo.Produto;
import br.com.loja.repositorio.RepositorioDeProdutos;

@Resource
public class ProdutosController {

	private final RepositorioDeProdutos repositorioDeProdutos;
	
	private final Result result;

	public ProdutosController(Result result, RepositorioDeProdutos repositorioDeProdutos) {
		this.result = result;
		this.repositorioDeProdutos = repositorioDeProdutos;
	}
	
	public void adiciona(Produto produto) {
		repositorioDeProdutos.insere(produto);
		result.redirectTo(this).lista();
	}

	public void atualiza(Produto produto) {
		repositorioDeProdutos.atualiza(produto);
	}

	public Produto obtemPorId(Long id) {
		return repositorioDeProdutos.obtemPorId(id);
	}
	
	@Path("/produtos/lista")
	public List<Produto> lista() {
		return repositorioDeProdutos.listaTodos();
	}

	public Produto edita(Long id) {
		return repositorioDeProdutos.obtemPorId(id);
	}
	
	public void altera(Produto produto) {
		repositorioDeProdutos.atualiza(produto);
		result.redirectTo(this).lista();
	}
	
	public void remove(Long id) {
		Produto produto = repositorioDeProdutos.obtemPorId(id);
		repositorioDeProdutos.remove(produto);
		result.redirectTo(this).lista();
	}
	
	@Path("/produtos/formulario")
	public void formulario() {
	}

}
