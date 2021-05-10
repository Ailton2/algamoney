package br.com.algamoney.model;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class Pessoa {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	private String nome;
	
	private Boolean ativo;
	
	@Embedded
	private Endereco endereco;

	
}
