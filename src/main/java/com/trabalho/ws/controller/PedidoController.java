package com.trabalho.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.ws.domain.Pedido;
import com.trabalho.ws.service.PedidoService;

@RestController
@RequestMapping("/loged")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/pedido", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> cadastrarPedido(@RequestBody Pedido pedido){
		Pedido pedidoNovo = pedidoService.salvarPedido(pedido);
		return new ResponseEntity<>(pedidoNovo, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/pedido", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Pedido>> findAllPedidos(){
		Collection<Pedido> pedidosEncontrados = pedidoService.findAllPedidos();
		return new ResponseEntity<>(pedidosEncontrados, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/pedido/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> findOnePedido(@PathVariable Integer id){
		Pedido pedidosEncontrados = pedidoService.findOnePedido(id);
		return new ResponseEntity<>(pedidosEncontrados, HttpStatus.OK);
	}
}
