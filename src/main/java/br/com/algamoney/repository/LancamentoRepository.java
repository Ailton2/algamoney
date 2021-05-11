package br.com.algamoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.algamoney.model.Lancamento;
import br.com.algamoney.repository.lancamento.LancamentoRepositoryQuery;

@Component
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery  {

}
