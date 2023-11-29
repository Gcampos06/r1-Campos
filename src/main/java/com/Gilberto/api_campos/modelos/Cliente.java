package com.Gilberto.api_campos.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente implements Serializable{

	// Número de versión para la serialización
	private static final long serialVersionUID = 1L;

	// Identificador único generado automáticamente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;// Nombre del cliente
	
	private String balance;// Saldo del cliente (se asume que es una representación de cantidad de dinero)

	private String stateaccount;// Estado de la cuenta del cliente
	
	public Cliente() {// Constructor por defecto necesario para JPA
		
		
	}

	// Métodos getter y setter para acceder y modificar los atributos
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getStateaccount() {
		return stateaccount;
	}

	public void setStateaccount(String stateaccount) {
		this.stateaccount = stateaccount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
