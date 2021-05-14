package br.com.algamoney.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.algamoney.model.Pessoa;
import br.com.algamoney.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public List<Pessoa> buscarTodos(){
		
		return pessoaRepository.findAll();
	}
	
	public Pessoa salvar(Pessoa pessoa) {
	  return	pessoaRepository.save(pessoa);
	}
	
	public void excluir(Long id) {
		pessoaRepository.deleteById(id);
	}

	public Pessoa buscarPorId(Long id) {
		Optional<Pessoa> pessoaS = pessoaRepository.findById(id);
		if(pessoaS == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaS.get();
	}
	
	@Transactional
	public void atualizaStatusPessoa(Long id, Boolean ativo) {
		Pessoa pessoa = buscarPorId(id);
		pessoa.setAtivo(ativo);
		pessoaRepository.save(pessoa);
		
		
	}

	public void atualizaPessoa(Long id) {
		Pessoa pessoa = buscarPorId(id);
		
		pessoaRepository.save(pessoa);
		
		
		
	}
	

	
}
