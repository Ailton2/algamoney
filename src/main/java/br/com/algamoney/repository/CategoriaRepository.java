package br.com.algamoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.algamoney.model.Categoria;

@Component
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	


}
