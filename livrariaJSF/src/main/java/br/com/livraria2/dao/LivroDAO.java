package br.com.livraria2.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.livraria2.model.Livro;

@Stateful
public class LivroDAO {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	public LivroDAO(){
		
	}
	
	public void salvar(Livro livro){
		em.persist(livro);
	}
	public List<Livro> listar(){
        String jpql = "select distinct(l) from Livro l"
                + " join fetch l.autores";
		//String jpql = "select distinct(l) from livro l join fetch l.autores";
		return em.createQuery(jpql, Livro.class).getResultList();
	}

	public List<Livro> ultimosLancamentos() {
		String jpql = "select l from Livro l order by l.id desc";
		
		return em.createQuery(jpql, Livro.class)
			    .setMaxResults(5)
				.getResultList();
	}

	public List<Livro> demaisLivros() {
		String jpql = "select l from Livro l order by l.id desc";
		return em.createQuery(jpql, Livro.class)
			    .setFirstResult(5)
				.getResultList();
	}

	public Livro buscarPorId(Integer id) {
		return em.find(Livro.class, id);
		/*String jpql = "select l from Livro l join fetch l.autores where l.id = :id";
		return em.createQuery(jpql, Livro.class)
				.setParameter("id", id)
				.getSingleResult();*/
	}
	
}
