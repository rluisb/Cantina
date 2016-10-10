package com.trabalho.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.ws.domain.Cliente;
import com.trabalho.ws.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente login(Cliente cliente){
		Cliente clienteLogado = null;
		clienteLogado = clienteRepository.buscaUsuarioCliente(cliente.getUsuario());
		if(clienteLogado != null){
			if(clienteLogado.getUsuario().equals(cliente.getUsuario()) && clienteLogado.getSenha().equals(cliente.getSenha())){
				return clienteLogado;
			}
		}
		return null;
	}
	
	
}
