package br.com.algamoney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.algamoney.model.Cidade;
import br.com.algamoney.repository.CidadeRepository;

@CrossOrigin
@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	public ResponseEntity<?> pesquisarPorEstado(@RequestParam Long estado){
		
		List<Cidade> cidades = cidadeRepository.findByEstadoId(estado);
		
		return ResponseEntity.ok(cidades);
	}
}
