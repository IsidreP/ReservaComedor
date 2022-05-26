package com.comedor.service;

public interface IRolService {

	//Metodos del CRUD
	public List<Rol> listarRol(); 
	
	public Rol guardarRol(Rol roles);	
	
	public Rol RolXID(int  id); 
		
	public Rol actualizarRol(Rol roles); 
	
	public void eliminarRol(int id);
}

