package com.comedor.service;

import java.util.List;
import com.comedor.dto.Rol;

public interface IRolService {
	
	// READ todos roles
	public List<Rol> listarRoles();

	// CREATE nuevo rol
	public Rol guardarRol(Rol rol);

	// READ rol por id
	public Rol listarRolXID(Long idRol);

	// UPDATE rol
	public Rol actualizarRol(Rol rol);

	// DELETE rol
	public void eliminarRol(Long idRol);
}

