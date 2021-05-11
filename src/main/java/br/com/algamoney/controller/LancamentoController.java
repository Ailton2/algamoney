package br.com.algamoney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.algamoney.model.Lancamento;
import br.com.algamoney.repository.LancamentoRepository;
import br.com.algamoney.repository.filter.LancamantoFilter;
import br.com.algamoney.service.LancamentoService;

@CrossOrigin
@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
			
		   @Autowired
		   private LancamentoService lancamentoService;
			
		   @Autowired
		   private LancamentoRepository lancamentoRepository;
			
		   @GetMapping
		   public ResponseEntity<?> buscarTodos(){
			   
			   List<Lancamento> lancamentos = lancamentoService.buscarTodos();
			   return ResponseEntity.ok(lancamentos);
		   }
		   
		   @GetMapping("/{id}")
		   public ResponseEntity<?> buscarPorId(@PathVariable Long id){
			   
			   Lancamento lancamento = lancamentoService.buscarPorId(id);
			   return ResponseEntity.ok(lancamento);
		   }
		   
		   @PostMapping
		   public ResponseEntity<?> salvar(@RequestBody Lancamento lancamento){
			
			      lancamentoService.salvar(lancamento);
			   
			  return ResponseEntity.status(HttpStatus.CREATED).build();
			   
		   }
		   
		   @GetMapping("/filtro")
		   public Page<Lancamento> buscarPorDescricao(LancamantoFilter lancamantoFilter,Pageable pageable){
			  
			   return  (Page<Lancamento>) lancamentoService.pesquisar(lancamantoFilter, pageable);
			   
			  
		   }

		   @DeleteMapping("/{id}")
		   public void excluir(@PathVariable Long id){
			   
			    lancamentoService.deletar(id);
			   
			  
		   }
}
