package com.comedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comedor.service.IPlatoService;
import com.comedor.dao.IPlatoDAO;
import com.comedor.dto.Plato;

@Service
public class PlatoServiceImpl implements IPlatoService {

	@Autowired
	IPlatoDAO iPlatoDAO;

	@Override
	public List<Plato> listarPlato() {
		return iPlatoDAO.findAll();
	}

	@Override
	public Plato guardarPlato(Plato categoria) {
		return iPlatoDAO.save(categoria);
	}

	@Override
	public Plato platoXID(int id) {
		return iPlatoDAO.findById(id).get();
	}

	@Override
	public Plato actualizarPlato(Plato categoria) {
		return iPlatoDAO.save(categoria);
	}

	@Override
	public void eliminarPlato(int id) {
		iPlatoDAO.deleteById(id);
	}
	
}
