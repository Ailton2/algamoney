package br.com.algamoney.repository.lancamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.com.algamoney.model.Lancamento;
import br.com.algamoney.repository.filter.LancamantoFilter;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Lancamento> filtrar(LancamantoFilter lancamantoFilter,Pageable pageable) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Lancamento> criteria =builder.createQuery(Lancamento.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);
		
		Predicate[] predicates=criarRestricoes(lancamantoFilter,builder,root);
		criteria.where(predicates);
		
		TypedQuery<Lancamento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query,pageable);
		
		return new PageImpl<>(query.getResultList(), pageable,total(lancamantoFilter)) ;
	}





	private Predicate[] criarRestricoes(LancamantoFilter lancamantoFilter, CriteriaBuilder builder,
			Root<Lancamento> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(lancamantoFilter.getDescricao())) {
			predicates.add(builder.like (builder.lower(root.get("descricao")),"%"+ lancamantoFilter
					.getDescricao().toLowerCase() +"%"));
		}
		if(lancamantoFilter.getDataVencimentoDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(builder.lower(root.get("dataVencimentoDe")),"%"+ lancamantoFilter
					.getDataVencimentoDe()));	
		}
		if(lancamantoFilter.getDataVencimentoAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(builder.lower(root.get("dataVencimentoAte")),"%"+ lancamantoFilter
					.getDataVencimentoAte()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	

	private void adicionarRestricoesDePaginacao(TypedQuery<Lancamento> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPagina);
		
		
	}
	
	private Long total(LancamantoFilter lancamantoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);
		
		Predicate[] predicates = criarRestricoes(lancamantoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
