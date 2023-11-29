package com.Gilberto.api_campos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gilberto.api_campos.modelos.Cliente;
// Repositorio de JPA para la entidad Cliente con identificadores Long
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	

}
