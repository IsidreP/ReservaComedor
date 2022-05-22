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

	@GetMapping("/franjas")
	public List<Franja> listarFranjas() {
		return franjaServiceImpl.listarFranjas();
	}

	@PostMapping("/franjas")
	public Franja guardarFranja(@RequestBody Franja franja) {
		return franjaServiceImpl.guardarFranja(franja);
	}

	@GetMapping("/franjas/{idFranja}")
	public Franja listarFranjaPorId(@PathVariable(name = "idFranja") Long idFranja) {

		Franja franjaPorId = new Franja();
		franjaPorId = franjaServiceImpl.listarFranjaXID(idFranja);
		return franjaPorId;
	}

	@PutMapping("/franjas/{idFranja}")
	public Franja actualizarFranja(@RequestBody Franja franja, @PathVariable(name = "idFranja") Long idFranja) {

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

	@DeleteMapping("/franjas/{idFranjas}")
	public void eliminarFranja(@PathVariable(name = "idFranja") Long idFranja) {
		franjaServiceImpl.eliminarFranja(idFranja);
	}

}
