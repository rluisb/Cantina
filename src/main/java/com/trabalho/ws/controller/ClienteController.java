package com.trabalho.ws.controller;

import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.ws.domain.Cliente;
import com.trabalho.ws.domain.Produto;
import com.trabalho.ws.service.ClienteService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Cliente> autentucar(@RequestBody Cliente clienteFromJson) throws ServletException {
		System.out.println(clienteFromJson);

		if (clienteFromJson.getUsuario().equals(null) || clienteFromJson.getSenha().equals(null)) {
			throw new ServletException("NOME E SENHA OBRIGATORIOS");
		}

		Cliente clienteEncontrado = clienteService.buscarCliente(clienteFromJson);

		if (clienteEncontrado == null) {
			throw new ServletException("USUARIO NAO ENCONTRADO!");
		}

		if(!clienteEncontrado.getSenha().equals(clienteFromJson.getSenha())){
			throw new ServletException("USUARIO OU SENHA INVALIDO!");
		}
		
		String token = Jwts.builder().setSubject(clienteEncontrado.getUsuario())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)).compact();
		
		clienteEncontrado.setToken(new LoginReponse(token));
		return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
	}

	public class LoginReponse {
		public String token;

		public LoginReponse(String token) {
			this.token = token;
		}
	}

}
