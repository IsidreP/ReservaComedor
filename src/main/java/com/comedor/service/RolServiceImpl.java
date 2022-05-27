package com.comedor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comedor.dao.IRolDAO;
import com.comedor.dto.Rol;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	IRolDAO iRolDAO;

	@Override
	public List<Rol> listarRoles() {
		return iRolDAO.findAll();
	}

	@Override
	public Rol guardarRol(Rol rol) {
		return iRolDAO.save(rol);
	}

	@Override
	public Rol listarRolXID(Long idRol) {
		return iRolDAO.findById(idRol).get();
	}

	@Override
	public Rol actualizarRol(Rol rol) {
		return iRolDAO.save(rol);
	}

	@Override
	public void eliminarRol(Long idRol) {
		iRolDAO.deleteById(idRol);

	}

}
