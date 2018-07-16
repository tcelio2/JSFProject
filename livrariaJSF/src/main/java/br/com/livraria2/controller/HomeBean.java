package br.com.livraria2.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.livraria2.dao.LivroDAO;
import br.com.livraria2.model.Livro;

@Model
public class HomeBean {

	@Inject
	private LivroDAO livrodao;
	
	public List<Livro> ultimosLancamentos(){
		return livrodao.ultimosLancamentos();
	}
	
	
	public List<Livro> demaisLivros(){
		return livrodao.demaisLivros();
	}
	
	
}
