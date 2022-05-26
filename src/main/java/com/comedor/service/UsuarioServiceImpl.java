package com.comedor.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comedor.dao.UsuarioDAO;
import comedor.dto.Usuario;





@Service
public class  UsuarioServiceImpl implements UsuarioService{
	
	
	@Autowired
	UsuarioDAO UsuariosDAO;
	
	@Override
	public List<Usuario> listarUsuarios() {
		
		return UsuariosDAO.findAll();
	}

	@Override
	public Usuario guardarUsuarios(Usuario usuarios) {
		
		return UsuariosDAO.save(usuarios);
	}

	@Override
	public Usuario UsuariosXID(int id) {
		
		return UsuariosDAO.findById(id).get();
	}
	

	@Override
	public Usuario actualizarUsuarios(Usuario usuarios) {
		
		return UsuariosDAO.save(usuarios);
	}

	@Override
	public void eliminarUsuarios(int id) {
		
		UsuariosDAO.deleteById(id);
		
	}

}
