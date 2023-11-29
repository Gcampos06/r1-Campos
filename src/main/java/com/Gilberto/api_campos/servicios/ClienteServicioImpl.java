package com.Gilberto.api_campos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gilberto.api_campos.modelos.Cliente;
import com.Gilberto.api_campos.repositorios.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements IClienteServicio{// Inyección de dependencia del repositorio de clientes
    
	@Autowired
	ClienteRepositorio clienterepositorio;
	
	@Override
	public List<Cliente> consultar() {
		return clienterepositorio.findAll();
	}// Método para consultar todos los clientes

	@Override
	public Cliente crear(Cliente cliente) {
		return clienterepositorio.save(cliente);
	}// Método para crear un nuevo cliente

	@Override
	public Cliente modificarPorId(Long id) {  // Método para modificar un cliente por su ID
		return clienterepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {  // Método para eliminar un cliente por su ID
		clienterepositorio.deleteById(id);
		
	}

}
