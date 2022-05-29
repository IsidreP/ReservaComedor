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
import com.comedor.dto.Franja;
import com.comedor.service.FranjaServiceImpl;

@RestController
@RequestMapping("/api")
public class FranjaController {

	@Autowired
	FranjaServiceImpl franjaServiceImpl;

	// listar todas franjas
	@GetMapping("/franjas")
	public List<Franja> listarFranjas() {
		return franjaServiceImpl.listarFranjas();
	}

	// crear nueva franja
	@PostMapping("/franjas")
	public Franja guardarFranja(@RequestBody Franja franja) {
		return franjaServiceImpl.guardarFranja(franja);
	}

	// listar franja por id
	@GetMapping("/franjas/{id}")
	public Franja listarFranjaPorId(@PathVariable(name = "id") Long idFranja) {

		Franja franjaPorId = new Franja();
		franjaPorId = franjaServiceImpl.listarFranjaXID(idFranja);
		return franjaPorId;
	}

	// actualizar franja
	@PutMapping("/franjas/{id}")
	public Franja actualizarFranja(@RequestBody Franja franja, @PathVariable(name = "id") Long idFranja) {

		Franja franjaSeleccionada = new Franja();
		Franja franjaActualizada = new Franja();

		// obtenemos franja de la DB
		franjaSeleccionada = franjaServiceImpl.listarFranjaXID(idFranja);

		// seteamos nuevos valores
		franjaSeleccionada.setIdFranja(franja.getIdFranja());
		franjaSeleccionada.setInicioFranja(franja.getInicioFranja());
		franjaSeleccionada.setFinFranja(franja.getFinFranja());
		franjaSeleccionada.setOcupacionMaxima(franja.getOcupacionMaxima());

		// actualizamos franja en la DB
		franjaActualizada = franjaServiceImpl.actualizarFranja(franjaSeleccionada);

		return franjaActualizada;
	}

	// eliminar franja por id
	@DeleteMapping("/franjas/{id}")
	public void eliminarFranja(@PathVariable(name = "id") Long idFranja) {
		franjaServiceImpl.eliminarFranja(idFranja);
	}

}
