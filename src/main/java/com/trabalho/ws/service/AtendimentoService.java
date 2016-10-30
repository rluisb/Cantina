package com.trabalho.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.ws.domain.Atendimento;
import com.trabalho.ws.domain.Pedido;
import com.trabalho.ws.repository.AtendimentoRepository;
import com.trabalho.ws.repository.PedidoRepository;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	

	public Atendimento salvarAtendimento(Atendimento atendimento) {
		alteraStatusPedidoFechado(atendimento.getPedido().getId());
		return atendimentoRepository.save(atendimento);
	}

	public void alteraStatusPedidoFechado(Integer id) {
		if(pedidoRepository.exists(id)){
			Pedido pedidoAtendido = pedidoRepository.findOne(id);
			pedidoAtendido.setStatus("Fechado");
			pedidoRepository.saveAndFlush(pedidoAtendido);
		}
	}
}
