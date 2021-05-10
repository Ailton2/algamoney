package br.com.algamoney.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.algamoney.dao.CategoriaDao;
import br.com.algamoney.exception.EntidadeEmUsoException;
import br.com.algamoney.exception.EntidadeNaoEncontradaException;
import br.com.algamoney.model.Categoria;
import br.com.algamoney.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaDao dao;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public List<Categoria> listarTodos(){
		
		return  categoriaRepository.findAll();
		 
		 
	}


	@Transactional
	public void save(Categoria categoria) {
		
		categoriaRepository.save(categoria);
		
	}
	
	public Categoria buscarPorId(Long id) throws Exception{
		
        try {
			Optional<Categoria> categoria =categoriaRepository.findById(id);
			return categoria.get();
		} catch (Exception e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe categoria com o código %d ", id));
		}
			
     
			
	}
	
	@Transactional
	public void excluir(Long id) throws Exception {
		
		try {
		    	categoriaRepository.deleteById(id);
		

		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe categoria com o código %d ", id));
		
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("A categoria com o codigo %d não pode ser removida", id));
		}
		
		
	}
	
	public List<Categoria> buscaPorN(String nome){
		
		 List<Categoria> categorias= dao.buscarPorNome(nome);
		 
		 return categorias;
	}

}
