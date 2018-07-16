package br.com.livraria2.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.livraria2.model.Compra;

public class CompraDAO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager manager;

	public void salvar(Compra compra){
		manager.persist(compra);
	}
	
}
