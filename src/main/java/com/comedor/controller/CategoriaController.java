package com.comedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comedor.dto.Categoria;
import com.comedor.service.CategoriaServiceImpl;

@RestController
@RequestMapping("/api")
public class CategoriaController {

	@Autowired
	CategoriaServiceImpl categoriaServiceImpl;
	
	// listar todas categorías
	@GetMapping("/categorias")
	public List<Categoria> listarCategorias(){
		return categoriaServiceImpl.listarCategorias();
	}
	
	// crear nueva categoría
	@PostMapping("/categorias")
	public Categoria salvarCategoria(@RequestBody Categoria categoria) {
		
		return categoriaServiceImpl.guardarCategoria(categoria);
	}
	
	// listar categoría por id
	@GetMapping("/categorias/{id}")
	public Categoria categoriaXID(@PathVariable(name="id") int id) {
		
		Categoria categoria_xid= new Categoria();
		categoria_xid=categoriaServiceImpl.categoriaXID(id);
		return categoria_xid;
	}
	
	// actualizar categoría
	@PutMapping("/categorias/{id}")
	public Categoria actualizarCategoria(@PathVariable(name="id")int id,@RequestBody Categoria categoria) {
		
		Categoria categoria_seleccionada= new Categoria();
		Categoria categoria_actualizada= new Categoria();
		
		// obtenemos categoría de la DB
		categoria_seleccionada= categoriaServiceImpl.categoriaXID(id);
		
		// seteamos nuevos valores
		categoria_seleccionada.setNombreCategoria(categoria.getNombreCategoria());
		categoria_seleccionada.setPlato(categoria.getPlato()); 
		
		// actualizamos categoría en la DB
		categoria_actualizada = categoriaServiceImpl.actualizarCategoria(categoria_seleccionada);
		
		return categoria_actualizada;
	}

	// eliminar categoría por id
	@DeleteMapping("/categorias/{id}")
	public void eliminarCategoria(@PathVariable(name="id")int id) {
		categoriaServiceImpl.eliminarCategoria(id);
	}
	
}
