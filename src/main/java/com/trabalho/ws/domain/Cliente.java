package com.trabalho.ws.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.trabalho.ws.controller.ClienteController.LoginReponse;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cliente", nullable=true)
	private Integer id;
	@Column(name = "usuario", nullable = false)
	private String usuario;
	@Column(name = "senha", nullable = false)
	private String senha;
	@Column(name = "saldo", nullable=true)
	private Double saldo;
	@Transient
	private LoginReponse token;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public LoginReponse getToken() {
		return token;
	}
	public void setToken(LoginReponse token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", saldo=" + saldo + "]";
	}
}
