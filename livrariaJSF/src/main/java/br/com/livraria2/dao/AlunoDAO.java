package br.com.livraria2.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.livraria2.model.Aluno;

@Stateless
public class AlunoDAO {

	@PersistenceContext(unitName="exemplo_PU2")
	private EntityManager em;
	
	public AlunoDAO(){
		
	}
	
	public void salvar(Aluno aluno){
		em.persist(aluno);
	}
	
}
