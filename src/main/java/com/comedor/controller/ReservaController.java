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
import com.comedor.dto.Reserva;
import com.comedor.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;

	// listar todas reservas
	@GetMapping("/reservas")
	public List<Reserva> listarReservas() {
		return reservaServiceImpl.listarReservas();
	}

	// crear nueva reserva
	@PostMapping("/reservas")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}

	// listar reserva por id
	@GetMapping("/reservas/{id}")
	public Reserva listarReservaPorId(@PathVariable(name = "id") Long idReserva) {

		Reserva reservaPorId = new Reserva();
		reservaPorId = reservaServiceImpl.listarReservaXID(idReserva);
		return reservaPorId;
	}

	// actualizar reserva
	@PutMapping("/reservas/{id}")
	public Reserva actualizarReserva(@RequestBody Reserva reserva, @PathVariable(name = "id") Long idReserva) {

		Reserva reservaSeleccionada = new Reserva();
		Reserva reservaActualizada = new Reserva();

		// obtenemos reserva de la DB
		reservaSeleccionada = reservaServiceImpl.listarReservaXID(idReserva);

		// seteamos nuevos valores
		reservaSeleccionada.setIdReserva(reserva.getIdReserva());
		reservaSeleccionada.setFechaReservada(reserva.getFechaReservada());
		reservaSeleccionada.setPrecioTotal(reserva.getPrecioTotal());
		reservaSeleccionada.setPedirPlato(reserva.getPedirPlato());

		// actualizamos reserva en la DB
		reservaActualizada = reservaServiceImpl.actualizarReserva(reservaSeleccionada);

		return reservaActualizada;
	}

	// eliminar reserva por id
	@DeleteMapping("/reservas/{id}")
	public void eliminarReserva(@PathVariable(name = "id") Long idReserva) {
		reservaServiceImpl.eliminarReserva(idReserva);
	}

}
