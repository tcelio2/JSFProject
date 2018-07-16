package br.com.livraria2.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.livraria2.dao.LivroDAO;
import br.com.livraria2.model.CarrinhoCompras;
import br.com.livraria2.model.CarrinhoItem;
import br.com.livraria2.model.Livro;

@Model
public class CarrinhoComprasBean {

	@Inject
	private LivroDAO livroDao;
	@Inject
	private CarrinhoCompras carrinho;
	
	public String add(Integer id){
		Livro livro = livroDao.buscarPorId(id);
		CarrinhoItem item = new CarrinhoItem(livro);
		carrinho.add(item);
		
		return "carrinho?faces-redirect=true";
		
	}
	
	public void remover(CarrinhoItem item){
		carrinho.remover(item);
	}
	
	public List<CarrinhoItem> getItens(){
		return carrinho.getItens();
	}
	
}
