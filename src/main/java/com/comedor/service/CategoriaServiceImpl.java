package com.comedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comedor.dao.ICategoriaDAO;
import com.comedor.dto.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	ICategoriaDAO iCategoriaDAO;

	@Override
	public List<Categoria> listarCategorias() {
		return iCategoriaDAO.findAll();
	}

	@Override
	public Categoria guardarCategoria(Categoria categoria) {
		return iCategoriaDAO.save(categoria);
	}

	@Override
	public Categoria categoriaXID(int id) {
		return iCategoriaDAO.findById(id).get();
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		return iCategoriaDAO.save(categoria);
	}

	@Override
	public void eliminarCategoria(int id) {
		iCategoriaDAO.deleteById(id);
	}
	
}
