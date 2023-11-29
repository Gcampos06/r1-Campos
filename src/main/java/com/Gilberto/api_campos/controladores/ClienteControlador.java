package com.Gilberto.api_campos.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gilberto.api_campos.modelos.Cliente;
import com.Gilberto.api_campos.servicios.ClienteServicioImpl;

@RestController
@RequestMapping("/api/v1")
public class ClienteControlador {

	// Inyección de dependencias del servicio
	@Autowired
	ClienteServicioImpl clienteservicio;

	// Endpoint para obtener la lista de todos los clientes
	@GetMapping("/clientes")
	public List<Cliente> consultarCliente(){
		return clienteservicio.consultar();
		
	}
	// Endpoint para crear un nuevo cliente
	@PostMapping("/crear")
	public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){ // Llama al método del servicio para crear un nuevo cliente
		Cliente nuevo_cliente = clienteservicio.crear(cliente);
		return new ResponseEntity<>(nuevo_cliente, HttpStatus.CREATED);// Devuelve la respuesta con el nuevo cliente y el código de estado CREATED
	}

	// Endpoint para obtener un cliente por su ID
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> modificarPorId(@PathVariable long id){
		Cliente cliente1 =clienteservicio.modificarPorId(id);
		
		return ResponseEntity.ok(cliente1);
	}

	// Endpoint para actualizar un cliente por su ID
	@PutMapping("/cliente/{id}")
	public ResponseEntity<Cliente> actualizar(@PathVariable long id,@RequestBody Cliente cliente){
		Cliente cliente1 = clienteservicio.modificarPorId(id);// Actualiza las propiedades del cliente existente con los valores proporcionados
		cliente1.setNombre(cliente.getNombre());// Actualiza las propiedades del cliente existente con los valores proporcionados
		cliente1.setBalance(cliente.getBalance());
		cliente1.setStateaccount(cliente.getStateaccount());

		Cliente cliente_modificado = clienteservicio.crear(cliente1);
		return new ResponseEntity<>(cliente_modificado, HttpStatus.CREATED);
		
	}

	// Endpoint para eliminar un cliente por su ID
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarCliente(@PathVariable long id){
		this.clienteservicio.eliminar(id);
		// Crea un HashMap para indicar que el cliente fue eliminado
		HashMap<String, Boolean> estadoClienteEliminado = new HashMap<>();
		estadoClienteEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoClienteEliminado);// Devuelve la respuesta con el HashMap y el código de estado OK
		
		
	}
}
