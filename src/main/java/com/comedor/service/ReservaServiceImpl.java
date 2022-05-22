package com.comedor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comedor.dao.IReservaDAO;
import com.comedor.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	IReservaDAO iReservaDAO;

	@Override
	public List<Reserva> listarReservas() {
		return iReservaDAO.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		return iReservaDAO.save(reserva);
	}

	@Override
	public Reserva listarReservaXID(Long idReserva) {
		return iReservaDAO.findById(idReserva).get();
	}

	@Override
	public Reserva actualizarReserva(Reserva reserva) {
		return iReservaDAO.save(reserva);
	}

	@Override
	public void eliminarReserva(Long idReserva) {
		iReservaDAO.deleteById(idReserva);

	}

}
