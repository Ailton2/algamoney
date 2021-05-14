package br.com.algamoney.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.algamoney.dao.LancamentoDao;
import br.com.algamoney.model.Lancamento;
import br.com.algamoney.repository.LancamentoRepository;
import br.com.algamoney.repository.filter.LancamantoFilter;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoDao dao;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public List<Lancamento> buscarTodos(){
		
		return lancamentoRepository.findAll();
	}
	
	
	public Page<Lancamento> pesquisar(LancamantoFilter lancamentoFilter, Pageable pageable){
		
		return lancamentoRepository.filtrar(lancamentoFilter,pageable);
	}
	
	
	public Lancamento buscarPorId(Long id) {
		
		Optional<Lancamento> lancamento= lancamentoRepository.findById(id);
		
		return lancamento.get();
	}

	
	public void salvar(Lancamento lancamento) {
		
		lancamentoRepository.save(lancamento);
		
	}
	public void atualizarLancamento(Long id) {
		
		Lancamento lancamento = lancamentoRepository.getOne(id);
		
		lancamentoRepository.save(lancamento);
		
	}
	
	public void deletar(Long id) {
		
		lancamentoRepository.deleteById(id);
	}

}
