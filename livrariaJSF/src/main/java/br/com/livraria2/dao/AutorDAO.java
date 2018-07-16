package br.com.livraria2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.livraria2.model.Autor;

public class AutorDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Autor> listar(){
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
		
	}
}
