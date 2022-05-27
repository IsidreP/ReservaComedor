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

import com.comedor.dto.Plato;
import com.comedor.service.PlatoServiceImpl;

@RestController
@RequestMapping("/api")
public class PlatoController {

	@Autowired
	PlatoServiceImpl platoServiceImpl;
	
	@GetMapping("/platos")
	public List<Plato> listarPlato(){
		return platoServiceImpl.listarPlato();
	}
	
	
	@PostMapping("/platos")
	public Plato salvarPlato(@RequestBody Plato plato) {
		
		return platoServiceImpl.guardarPlato(plato);
	}
	
	
	@GetMapping("/platos/{id}")
	public Plato PlatoXID(@PathVariable(name="id") int idPlato) {
		
		Plato Plato_xid= new Plato();
		
		Plato_xid=platoServiceImpl.platoXID(idPlato);
	
		return Plato_xid;
	}
	
	@PutMapping("/platos/{id}")
	public Plato actualizarPlato(@PathVariable(name="id")int idPlato, @RequestBody Plato Plato) {
		
		Plato Plato_seleccionado= new Plato();
		Plato Plato_actualizado= new Plato();
		
		Plato_seleccionado= platoServiceImpl.platoXID(idPlato);
		
		
		Plato_seleccionado.setCategoria(Plato.getCategoria());
		Plato_seleccionado.setNombrePlato(Plato.getNombrePlato());
		Plato_seleccionado.setDescripcionPlato(Plato.getDescripcionPlato());
		Plato_seleccionado.setImagenPlato(Plato.getImagenPlato());
		Plato_seleccionado.setPrecioPlato(Plato.getPrecioPlato());
		Plato_seleccionado.setPedirPlato(Plato.getPedirPlato());
		
		Plato_actualizado = platoServiceImpl.actualizarPlato(Plato_seleccionado);
		
		return Plato_actualizado;
	}
	
	@DeleteMapping("/platos/{id}")
	public void eleiminarPlato(@PathVariable(name="id")int idPlato) {
		platoServiceImpl.eliminarPlato(idPlato);
	}
	
}
