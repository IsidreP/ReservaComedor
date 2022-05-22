package com.comedor.service;

import java.util.List;
import com.comedor.dto.Reserva;

public interface IReservaService {
	
	// READ todas reservas
	public List<Reserva> listarReservas();

	// CREATE nueva reserva
	public Reserva guardarReserva(Reserva reserva);

	// READ reserva por id
	public Reserva listarReservaXID(Long idReserva);

	// UPDATE reserva
	public Reserva actualizarReserva(Reserva reserva);

	// DELETE reserva
	public void eliminarReserva(Long idReserva);

}
