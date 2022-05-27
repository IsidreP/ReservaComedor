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
import com.comedor.dto.PedirPlato;
import com.comedor.service.PedirPlatoServiceImpl;

@RestController
@RequestMapping("/api")
public class PedirPlatoController {

	@Autowired
	 PedirPlatoServiceImpl  pedirPlatoServiceImpl;

	@GetMapping("/pedirPlato")
	public List<PedirPlato> listarPedirPlatos() {
		return pedirPlatoServiceImpl.listarPedirPlato();
	}

	@PostMapping("/pedirPlato")
	public PedirPlato guardarPedirPlato(@RequestBody PedirPlato pedirPlato) {
		return pedirPlatoServiceImpl.guardarPedirPlato(pedirPlato);
	}

	@GetMapping("/pedirPlato/{id}")
	public PedirPlato listarPedirPlatoPorId(@PathVariable(name = "id") Long idPedirPlato) {

		PedirPlato pedirPlatoPorId = new PedirPlato();
		pedirPlatoPorId = pedirPlatoServiceImpl.listarPedirPlatoXID(idPedirPlato);
		return pedirPlatoPorId;
	}

	@PutMapping("/pedirPlato/{id}")
	public PedirPlato actualizarPedirPlato(@RequestBody PedirPlato pedirPlato, @PathVariable(name = "id") Long idPedirPlato) {

		PedirPlato pedirPlatoSeleccionado = new PedirPlato();
		PedirPlato pedirPlatoActualizado = new PedirPlato();

		// obtenemos pedirPlato de la DB
		pedirPlatoSeleccionado = pedirPlatoServiceImpl.listarPedirPlatoXID(idPedirPlato);

		// seteamos nuevos valores
		pedirPlatoSeleccionado.setIdPedirPlato(pedirPlato.getIdPedirPlato());
		pedirPlatoSeleccionado.setUsuario(pedirPlato.getUsuario());
		pedirPlatoSeleccionado.setPlato(pedirPlato.getPlato());
		pedirPlatoSeleccionado.setFranja(pedirPlato.getFranja());

		// actualizamos pedirPlato en la DB
		pedirPlatoActualizado = pedirPlatoServiceImpl.actualizarPedirPlato(pedirPlatoSeleccionado);

		return pedirPlatoActualizado;
	}

	@DeleteMapping("/pedirPlato/{id}")
	public void eliminarPedirPlato(@PathVariable(name = "id") Long idPedirPlato) {
		pedirPlatoServiceImpl.eliminarPedirPlato(idPedirPlato);
	}

}
