package com.trabalho.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.ws.domain.Pedido;
import com.trabalho.ws.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido salvarPedido(Pedido pedido){
		return pedidoRepository.save(pedido);
	}
	
	public Collection<Pedido> findAllPedidos(){
		return pedidoRepository.findAll();
	}
	
	public Pedido findOnePedido(Integer id){
		return pedidoRepository.findOne(id);
	}
	
}
