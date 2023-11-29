package com.Gilberto.api_campos.servicios;

import java.util.List;

import com.Gilberto.api_campos.modelos.Cliente;

public interface IClienteServicio {// Interfaz que define el contrato para los servicios relacionados con la entidad Cliente

	public List<Cliente> consultar(); // Método para consultar todos los clientes
	
	public Cliente crear(Cliente cliente); // Método para crear un nuevo cliente
	
	public Cliente modificarPorId(Long id);  // Método para modificar un cliente por su ID
	
	public void eliminar(long id); // Método para eliminar un cliente por su ID
	

}
