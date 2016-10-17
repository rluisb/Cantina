package com.trabalho.ws.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.ws.domain.Cliente;
import com.trabalho.ws.service.ClienteService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public LoginReponse autentucar(@RequestBody Cliente clienteFromJson) throws ServletException {
		System.out.println(clienteFromJson);

		if (clienteFromJson.getUsuario().equals(null) || clienteFromJson.getSenha().equals(null)) {
			throw new ServletException("NOME E SENHA OBRIGATORIOS");
		}

		Cliente clienteFromDB = clienteService.buscarCliente(clienteFromJson);

		if (clienteFromDB == null) {
			throw new ServletException("USUARIO NAO ENCONTRADO!");
		}

		if(!clienteFromDB.getSenha().equals(clienteFromJson.getSenha())){
			throw new ServletException("USUARIO OU SENHA INVALIDO!");
		}
		
		String token = Jwts.builder().setSubject(clienteFromDB.getUsuario())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();

		return new LoginReponse(token);

	}

	private class LoginReponse {
		@SuppressWarnings("unused")
		public String token;

		public LoginReponse(String token) {
			this.token = token;
		}
	}

}
