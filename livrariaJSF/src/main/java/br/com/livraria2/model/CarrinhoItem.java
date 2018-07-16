package br.com.livraria2.model;

public class CarrinhoItem {
	
	private Livro livro;
	private Integer quantidade;
	
	public CarrinhoItem(Livro livro){
		this.livro = livro;
		this.quantidade = 1;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
