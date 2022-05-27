package com.comedor.service;

import java.util.List;
import com.comedor.dto.Usuario;

public interface IUsuarioService {

	// READ todos usuarios
	public List<Usuario> listarUsuarios();

	// CREATE nuevo usuario
	public Usuario guardarUsuario(Usuario usuario);

	// READ usuario por id
	public Usuario listarUsuarioXID(Long idUsuario);

	// UPDATE usuario
	public Usuario actualizarUsuario(Usuario usuario);

	// DELETE usuario
	public void eliminarUsuario(Long idUsuario);
	
}
