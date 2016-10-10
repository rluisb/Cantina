package com.trabalho.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.ws.domain.Atendimento;
import com.trabalho.ws.service.AtendimentoService;

@RestController
public class AtendimentoController {

	@Autowired
	private AtendimentoService atendimentoService;
	
	@RequestMapping(value = "/atendimento", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Atendimento> cadastrarAtendimento(@RequestBody Atendimento atendimento){
		Atendimento atendimentoNovo = atendimentoService.salvarAtendimento(atendimento);
		return new ResponseEntity<>(atendimentoNovo, HttpStatus.OK);
	}
}
