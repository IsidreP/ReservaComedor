package com.comedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comedor.dao.RolDAO;
import comedor.dto.Rol;



@Service
public class RolServiceImpl implements RolService{
	
	
	@Autowired
	RolDAO RolDAO;
	
	@Override
	public List<Rol> listarRol() {
		
		return RolDAO.findAll();
	}

	@Override
	public Rol guardarRol(Rol roles) {
		
		return RolDAO.save(roles);
	}

	@Override
	public Rol RolXID(int id) {
		
		return RolDAO.findById(id).get();
	}
	

	@Override
	public Rol actualizarRol(Rol roles) {
		
		return RolDAO.save(roles);
	}

	@Override
	public void eliminarRol(int id) {
		
		RolDAO.deleteById(id);
		
	}

}
