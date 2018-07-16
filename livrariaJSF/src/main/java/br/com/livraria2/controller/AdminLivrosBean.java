package br.com.livraria2.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.livraria2.dao.AutorDAO;
import br.com.livraria2.dao.LivroDAO;
import br.com.livraria2.infra.FileSaver;
import br.com.livraria2.model.Autor;
import br.com.livraria2.model.Livro;

@Named
@RequestScoped
public class AdminLivrosBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Livro livro = new Livro();
	
	@Inject
	private LivroDAO dao;
	
	@Inject
	private AutorDAO autorDao;
	
	@Inject
	private FacesContext context;
	
	private Part capaLivro;
	
		
	@Transactional
	public String salvar(){
		
		dao.salvar(livro);
		FileSaver fileSaver = new FileSaver(); //<----elemento novo
		livro.setCapaPath(fileSaver.write(capaLivro, "livros"));//<----elemento novo
		
		context.getExternalContext()
				.getFlash().setKeepMessages(true);
		
		context
			.addMessage(null, 
					new FacesMessage("Livro cadastrado com sucesso!"));
		
		//itens abaixo somente para limpar os dados do formulario
		this.livro = new Livro();
		
		return "/livros/lista?faces-redirect=true";
		
	}
	
	public List<Autor> getAutores(){
		return autorDao.listar();
	}
	
	public Livro getLivro() {
		return livro; 
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	
	public String goToLista(){
		return "/livros/lista?faces-redirect=true";
	}

	public Part getCapaLivro() {
		return capaLivro;
	}

	public void setCapaLivro(Part capaLivro) {
		this.capaLivro = capaLivro;
	}
	
	
}
