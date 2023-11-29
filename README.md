# r1-Campos
Api_Rest

Esta API es una aplicación construida con Spring Boot 3.1.6  la cual permite a los usuarios utlitzar las siguientes funciones:crear, leer, actualizar y eliminar , utilizando Spring tool Suite 4 para crear los códigos.

Siguientes Funcionalidades El API proporciona las funcionalidades para manejar cuentas:

Crear una nueva cuenta. Leer todas las cuentas. Leer una cuenta por su ID. Actualizar una cuenta existente. Eliminar una cuenta. Cada cuenta tiene los siguientes atributos:

•	Nombre del cliente. 

•	Número de cuenta.

•	Saldo de la cuenta.

•	Estado de la cuenta.



Uso:
La API se puede usar a través de las siguientes URL:
•	GET http://localhost:8080/api/v1/accounts : devuelve una lista de todas las cuentas.
   •	GET http://localhost:8080/api/v1/clientes : devuelve una lista de todas las cuentas o clientes.
   Debe mostrase de la sig. forma [{"id":5,"nombre":"Camilita","balance":"1000.0","stateaccount":"cancelado"},{"id":6,"nombre":"Killy","balance":"368.00","stateaccount":"Activo"},{"id":8,"nombre":"Manuel","balance":"200.0","stateaccount":"Cancelado"},{"id":10,"nombre":"Antonio","balance":"10.0","stateaccount":"Activo"}]

•	GET http://localhost:8080/api/v1/accounts/{id} : devuelve una cuenta específica según su ID.
          •	GET http://localhost:8080/api/v1/cliente/5
            Ejemplo:{"id":5,"nombre":"Camilita","balance":"1000.0","stateaccount":"cancelado"}
•	POST http://localhost:8080/api/v1/accounts : crea una nueva cuenta.
        •	POST http://localhost:8080/api/v1/crear

{
  "balance": 1500.00,
  "nombre": "Rodrigo",
  "stateaccount": "Activo"
}
Una vez creado deberia pasar a esta forma:
{
    "id": 11,              Id como numero de cuenta unico
    "nombre": "Rodrigo",   nombre del cliente
    "balance": "1500.00",  Saldo de la cuenta
    "stateaccount": "Activo"  Estado de la cuenta
}
•	PUT http://localhost:8080/api/v1/accounts/{id} : actualiza una cuenta existente según su ID.
         •	PUT http://localhost:8080/api/v1/cliente/11  >>>En este caso el que acabamos de crear.
              {
  "balance": 1500.00,
  "nombre": "Carmen",
  "stateaccount": "Inactivo"
}
>>>Se muestra de la sig. manera
>>>{
    "id": 11,
    "nombre": "Carmen",
    "balance": "1500.00",
    "stateaccount": "Inactivo"
}

•	DELETE http://localhost:8080/api/v1/accounts/{id} : elimina una cuenta según su ID.
   •	DELETE   http://localhost:8080/api/v1/cliente/11
   {
    "eliminado": true
}
Todo este test fue realizado en Postman.
metodo por metodo.

Mostraré algunos de los código que coloque para las API:
POST:
//crea un nuevo usuario en la base de datos
public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){ // Llama al método del servicio para crear un nuevo cliente
		Cliente nuevo_cliente = clienteservicio.crear(cliente);
		return new ResponseEntity<>(nuevo_cliente, HttpStatus.CREATED);// Devuelve la respuesta con el nuevo cliente y el código de estado CREATED
	}


PUT:
public ResponseEntity<Cliente> actualizar(@PathVariable long id,@RequestBody Cliente cliente){
		Cliente cliente1 = clienteservicio.modificarPorId(id);// Actualiza las propiedades del cliente existente con los valores proporcionados
		cliente1.setNombre(cliente.getNombre());// Actualiza las propiedades del cliente existente con los valores proporcionados
		cliente1.setBalance(cliente.getBalance());
		cliente1.setStateaccount(cliente.getStateaccount());

		Cliente cliente_modificado = clienteservicio.crear(cliente1);
		return new ResponseEntity<>(cliente_modificado, HttpStatus.CREATED);
		
	}
