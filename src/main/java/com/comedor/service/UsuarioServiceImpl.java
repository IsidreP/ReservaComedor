package com.comedor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comedor.dao.IUsuarioDAO;
import com.comedor.dto.Usuario;

@Service
public class  UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	IUsuarioDAO iUsuariosDAO;

	@Override
	public List<Usuario> listarUsuarios() {
		return iUsuariosDAO.findAll() ;
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return iUsuariosDAO.save(usuario);
	}

	@Override
	public Usuario listarUsuarioXID(Long idUsuario) {
		return iUsuariosDAO.findById(idUsuario).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return iUsuariosDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long idUsuario) {
		iUsuariosDAO.deleteById(idUsuario);
		
	}
	
}
