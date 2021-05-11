package br.com.algamoney.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.algamoney.model.Lancamento;
import br.com.algamoney.repository.filter.LancamantoFilter;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamantoFilter lancamantoFilter,Pageable pageable);
}
