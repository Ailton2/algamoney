package br.com.algamoney.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.algamoney.model.Categoria;


@Repository
public class CategoriaDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	
	public List<Categoria> buscarTodos() {
		
		return manager.createQuery("from Categoria",Categoria.class).getResultList();
	}



	public Categoria buscarPorId(Long id) {
		return manager.find(Categoria.class, id);
	}


	@Transactional
	public Categoria salvar(Categoria categoria) {
		
		return manager.merge(categoria);
	}


    @Transactional
	public void deletar(Long id) {
	  Categoria categoria=buscarPorId(id);
	  if(categoria == null) {
		  throw new EmptyResultDataAccessException(1);
	  }
		 manager.remove(categoria);
	}



	public List<Categoria> buscarPorNome(String nome) {
		
		return manager.createQuery("from Categoria where nome = :nome",Categoria.class)
				.setParameter("nome",nome).getResultList();
	}



}
