package br.com.algamoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.algamoney.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
