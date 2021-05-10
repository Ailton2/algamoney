package br.com.algamoney.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
