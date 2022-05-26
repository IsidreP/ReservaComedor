package com.comedor.service;

import java.util.List;

import com.comedor.dto.Categoria;

public interface ICategoriaService {

	
	//Metodos del CRUD
	public List<Categoria> listarCategorias(); //Listar All 
	
	public Categoria guardarCategoria(Categoria categoria);	//Guarda un Categoria CREATE
	
	public Categoria categoriaXID(int id); //Leer datos de un Categoria READ
	
	public Categoria actualizarCategoria(Categoria categoria); //Actualiza datos del Categoria UPDATE
	
	public void eliminarCategoria(int id);// Elimina el Categoria DELETE
}
