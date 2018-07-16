package br.com.livraria2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.livraria2.dao.LivroDAO;
import br.com.livraria2.model.Livro;

@Model
public class LivroListaBean {

	@Inject
	private LivroDAO livrodao;
	
	private List<Livro> livros = new ArrayList<>();
	
	
	public String novoLivro(){
		return "/index?faces-redirect=true";
	}


	public List<Livro> getLivros() {
		return this.livros = livrodao.listar();
	}


	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}


	
	
	
	
	
}
