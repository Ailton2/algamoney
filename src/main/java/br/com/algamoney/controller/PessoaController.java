package br.com.algamoney.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.algamoney.model.Pessoa;
import br.com.algamoney.repository.PessoaRepository;
import br.com.algamoney.service.PessoaService;

@CrossOrigin
@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public ResponseEntity<?> buscar() {
		
		List<Pessoa> pessoas = pessoaService.buscarTodos();
		return ResponseEntity.ok(pessoas);
	}

	@PostMapping
	public ResponseEntity<?> salvarPessoas(@RequestBody Pessoa pessoa){
		
		   pessoaService.salvar(pessoa);
		   
		   return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirPessoa(@PathVariable Long id){
		
		pessoaService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		
		       Pessoa pessoa =  pessoaService.buscarPorId(id);
		
		  return ResponseEntity.ok().body(pessoa);
	}
	
	
	@PutMapping("/{id}/ativo")
	public void atualizaStatus(@PathVariable Long id,@RequestBody Boolean ativo) {
		pessoaService.atualizaStatusPessoa(id,ativo);
	}
	@PutMapping("/{id}")
	public Pessoa atualizaPessoa(@PathVariable Long id,@RequestBody Pessoa pessoa) {
		
		Pessoa pessoaBuscada= pessoaService.buscarPorId(id);
		 
		BeanUtils.copyProperties(pessoa, pessoaBuscada,"id","ativo");
		pessoaService.salvar(pessoaBuscada);
		
		return pessoaBuscada;
	}
	
	@GetMapping("/nome")
	public ResponseEntity<?> buscarPorNome(@RequestParam String nome){
		
		List<Pessoa> pessoas = pessoaRepository.findByNomeContaining(nome);
		
		return ResponseEntity.ok(pessoas);
		
	}
}
