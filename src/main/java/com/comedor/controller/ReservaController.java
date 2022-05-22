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

	@GetMapping("/reservas")
	public List<Reserva> listarReservas() {
		return reservaServiceImpl.listarReservas();
	}

	@PostMapping("/reservas")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}

	@GetMapping("/reservas/{idReserva}")
	public Reserva listarReservaPorId(@PathVariable(name = "idReserva") Long idReserva) {

		Reserva reservaPorId = new Reserva();
		reservaPorId = reservaServiceImpl.listarReservaXID(idReserva);
		return reservaPorId;
	}

	@PutMapping("/reservas/{idReserva}")
	public Reserva actualizarReserva(@RequestBody Reserva reserva, @PathVariable(name = "idReserva") Long idReserva) {

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

	@DeleteMapping("/reservas/{idReservas}")
	public void eliminarReserva(@PathVariable(name = "idReserva") Long idReserva) {
		reservaServiceImpl.eliminarReserva(idReserva);
	}

	

}
