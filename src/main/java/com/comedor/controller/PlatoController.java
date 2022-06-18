package com.comedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comedor.dto.Plato;
import com.comedor.service.PlatoServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PlatoController {

	@Autowired
	PlatoServiceImpl platoServiceImpl;
	
	// listar todos platos
	@GetMapping("/platos")
	public List<Plato> listarPlato(){
		return platoServiceImpl.listarPlato();
	}
	
	// crear nuevo plato
	@PostMapping("/platos")
	public Plato salvarPlato(@RequestBody Plato plato) {
		
		return platoServiceImpl.guardarPlato(plato);
	}
	
	// listar plato por id
	@GetMapping("/platos/{id}")
	public Plato PlatoXID(@PathVariable(name="id") int idPlato) {
		
		Plato plato_xid= new Plato();
		plato_xid=platoServiceImpl.platoXID(idPlato);
		return plato_xid;
	}
	
	// actualizar plato
	@PutMapping("/platos/{id}")
	public Plato actualizarPlato(@PathVariable(name="id")int idPlato, @RequestBody Plato Plato) {
		
		Plato plato_seleccionado= new Plato();
		Plato plato_actualizado= new Plato();
		
		// obtenemos plato de la DB
		plato_seleccionado= platoServiceImpl.platoXID(idPlato);
		
		// seteamos nuevos valores
		plato_seleccionado.setCategoria(Plato.getCategoria());
		plato_seleccionado.setNombrePlato(Plato.getNombrePlato());
		plato_seleccionado.setDescripcionPlato(Plato.getDescripcionPlato());
		plato_seleccionado.setImagenPlato(Plato.getImagenPlato());
		plato_seleccionado.setPrecioPlato(Plato.getPrecioPlato());
		plato_seleccionado.setPedirPlato(Plato.getPedirPlato());
		
		// actualizamos plato en la DB
		plato_actualizado = platoServiceImpl.actualizarPlato(plato_seleccionado);
		
		return plato_actualizado;
	}
	
	// eliminar plato por id
	@CrossOrigin
	@DeleteMapping("/platos/{id}")
	public void eliminarPlato(@PathVariable(name="id")int idPlato) {
		platoServiceImpl.eliminarPlato(idPlato);
	}
	
}
