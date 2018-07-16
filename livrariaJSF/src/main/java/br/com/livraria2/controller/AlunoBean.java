package br.com.livraria2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.livraria2.dao.AlunoDAO;
import br.com.livraria2.model.Aluno;

@Named
@RequestScoped
public class AlunoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AlunoDAO dao;
	
	private Aluno aluno;
	
	@PostConstruct
	public void init(){
		aluno = new Aluno();
	}
	
	@Transactional
	public void salvar(){
		dao.salvar(aluno);
	}

	public AlunoDAO getDao() {
		return dao;
	}

	public void setDao(AlunoDAO dao) {
		this.dao = dao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String outraPagina(){
		return "produtos/form?faces-redirect=true";
	}
	/*public List<Autor> getAutores(){	
		//return Arrays.asList(new Autor(1, "Machado de Assis"),new Autor(2,"Guimarães Rosa"));
	}*/
	
}
