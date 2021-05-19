package br.com.algamoney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.algamoney.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	 List<Cidade> findByEstadoId(Long idestado);
}
