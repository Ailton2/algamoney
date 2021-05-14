package br.com.algamoney.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.algamoney.exception.EntidadeEmUsoException;
import br.com.algamoney.exception.EntidadeNaoEncontradaException;
import br.com.algamoney.model.Categoria;
import br.com.algamoney.service.CategoriaService;

@CrossOrigin
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		
		List<Categoria> categorias = categoriaService.listarTodos();
		 return ResponseEntity.ok(categorias);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Categoria categoria) {
		
		categoriaService.save(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarId(@PathVariable Long id) throws Exception {
		
		Categoria categoria= categoriaService.buscarPorId(id);
		if (categoria != null) {
			return ResponseEntity.ok(categoria);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) throws Exception{
		try {

			categoriaService.excluir(id);	

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		
	}
	
	@GetMapping("/por-nome")
	public List<Categoria> buscaPorN(@RequestParam String nome){
		
		List<Categoria> categorias= categoriaService.buscaPorN(nome);
		
		return categorias;
		
	}
}
