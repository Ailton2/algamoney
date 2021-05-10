package br.com.algamoney.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.algamoney.model.Pessoa;

@Repository
public class PessoaDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	
	public List<Pessoa> buscarTodos() {
		
		return manager.createQuery("from Pessoa",Pessoa.class).getResultList();
	}


}
