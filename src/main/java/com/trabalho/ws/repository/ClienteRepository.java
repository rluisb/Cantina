package com.trabalho.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trabalho.ws.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query(value = "SELECT c FROM Cliente c WHERE c.usuario=:pusuario AND c.senha=:psenha")
	public Cliente buscarClientePorLogin(@Param("pusuario") String usuario, @Param("psenha") String senha);

}
