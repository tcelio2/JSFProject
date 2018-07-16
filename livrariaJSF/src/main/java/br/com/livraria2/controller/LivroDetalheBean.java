package br.com.livraria2.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.livraria2.dao.LivroDAO;
import br.com.livraria2.model.Livro;

@Model
public class LivroDetalheBean {

	@Inject
	private LivroDAO livrodao;
	
	private Livro livro;
	
	private Integer id; //ao clicar em detalhe, este bean fica com o ID do livro que sera usado
						//posteriormente para mostrar o detalhe dos livros.	
	
	
	
	public void carregaDetalhe(){
		this.livro = livrodao.buscarPorId(id);
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Livro getLivro() {
		return livro;
	}



	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
