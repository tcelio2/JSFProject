package br.com.livraria2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.livraria2.model.Usuario;

public class UsuarioDAO {

	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Usuario usuario){
		manager.persist(usuario);
	}
}
