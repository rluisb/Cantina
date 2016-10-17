package com.trabalho.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.ws.domain.Cliente;
import com.trabalho.ws.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarCliente(Cliente clienteFromJson){
		Cliente cliente = new Cliente();
		
		cliente = clienteRepository.buscarClientePorLogin(clienteFromJson.getUsuario(), clienteFromJson.getSenha());
		if(cliente == null){
			System.out.println("CLIENTE NAO ENCONTRADO");
		}
		return cliente;
	}
	
}
