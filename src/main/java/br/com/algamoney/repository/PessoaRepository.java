package br.com.algamoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


import br.com.algamoney.model.Pessoa;

@Component
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
