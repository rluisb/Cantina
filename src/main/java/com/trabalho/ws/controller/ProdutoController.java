package com.trabalho.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.ws.domain.Produto;
import com.trabalho.ws.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/cardapio", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Produto>> findAllProducts(){
		Collection<Produto> produtosBuscados = produtoService.findAllProducts();
		return new ResponseEntity<>(produtosBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cardapio/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> findOneProduct(@PathVariable Integer id){
		Produto produtoEncontrado = produtoService.findOneProduct(id);
		return new ResponseEntity<>(produtoEncontrado, HttpStatus.OK);
	}
	
}
