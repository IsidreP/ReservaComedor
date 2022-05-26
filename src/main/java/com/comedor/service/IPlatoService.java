package com.comedor.service;

import java.util.List;

import com.comedor.dto.Plato;

public interface IPlatoService {
	
	//Metodos del CRUD
	public List<Plato> listarPlato(); //Listar All 
	
	public Plato guardarPlato(Plato plato);	//Guarda un Plato CREATE
	
	public Plato platoXID(int id); //Leer datos de un Plato READ
	
	public Plato actualizarPlato(Plato plato); //Actualiza datos del Plato UPDATE
	
	public void eliminarPlato(int id);// Elimina el Plato DELETE

}
