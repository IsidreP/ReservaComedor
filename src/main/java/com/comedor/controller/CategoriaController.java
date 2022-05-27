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
	
	@GetMapping("/categorias")
	public List<Categoria> listarCategorias(){
		return categoriaServiceImpl.listarCategorias();
	}
	
	
	@PostMapping("/categorias")
	public Categoria salvarCategoria(@RequestBody Categoria categoria) {
		
		return categoriaServiceImpl.guardarCategoria(categoria);
	}
	
	
	@GetMapping("/categorias/{id}")
	public Categoria categoriaXID(@PathVariable(name="id") int id) {
		
		Categoria Categoria_xid= new Categoria();
		
		Categoria_xid=categoriaServiceImpl.categoriaXID(id);
	
		return Categoria_xid;
	}
	
	@PutMapping("/categorias/{id}")
	public Categoria actualizarCategoria(@PathVariable(name="id")int id,@RequestBody Categoria categoria) {
		
		Categoria Categoria_seleccionado= new Categoria();
		Categoria Categoria_actualizado= new Categoria();
		
		Categoria_seleccionado= categoriaServiceImpl.categoriaXID(id);
		
		Categoria_seleccionado.setNombreCategoria(categoria.getNombreCategoria());
		Categoria_seleccionado.setPlato(categoria.getPlato()); // AÑADIDO
		
		Categoria_actualizado = categoriaServiceImpl.actualizarCategoria(Categoria_seleccionado);
		
		return Categoria_actualizado;
	}
	
	@DeleteMapping("/categorias/{id}")
	public void eleiminarCategoria(@PathVariable(name="id")int id) {
		categoriaServiceImpl.eliminarCategoria(id);
	}
	
}
