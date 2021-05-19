package br.com.algamoney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.algamoney.model.Estado;
import br.com.algamoney.repository.EstadoRepository;

@CrossOrigin
@RestController
@RequestMapping("/estados")
public class EstadoContoller {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		
		List<Estado> estados = estadoRepository.findAll();
		
		return ResponseEntity.ok(estados);
	}

}
