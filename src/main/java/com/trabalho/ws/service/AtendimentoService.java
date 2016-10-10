package com.trabalho.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.ws.domain.Atendimento;
import com.trabalho.ws.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
		
	public Atendimento salvarAtendimento(Atendimento atendimento){
		return atendimentoRepository.save(atendimento);
	}
}
