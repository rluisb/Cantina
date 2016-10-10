package com.trabalho.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.ws.domain.Produto;
import com.trabalho.ws.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Collection<Produto> findAllProducts(){
		return produtoRepository.findAll();
	}
	
	public Produto findOneProduct(Integer id){
		return produtoRepository.findOne(id);
	}
	
}
