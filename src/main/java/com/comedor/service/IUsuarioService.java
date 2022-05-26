package com.comedor.service;

import java.util.List;


import comedor.dto.Usuario;


public interface IUsuarioService {

	//Metodos del CRUD
	public List< Usuario> listarUsuarios(); 
	
	public  Usuario guardarUsuarios(Usuario usuarios);	
	
	public  Usuario  UsuariosXID(int id); 
	
	public  Usuario actualizarUsuarios(Usuario usuarios); 
	
	public void eliminarUsuarios(int id);
	
	
}
