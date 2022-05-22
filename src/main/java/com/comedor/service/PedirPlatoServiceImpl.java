package com.comedor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comedor.dao.IPedirPlatoDAO;
import com.comedor.dto.PedirPlato;

@Service
public class PedirPlatoServiceImpl implements IPedirPlatoService {

	@Autowired
	IPedirPlatoDAO iPedirPlatoDAO;

	@Override
	public List<PedirPlato> listarPedirPlato() {
		return iPedirPlatoDAO.findAll();
	}

	@Override
	public PedirPlato guardarPedirPlato(PedirPlato pedirPlato) {
		return iPedirPlatoDAO.save(pedirPlato);
	}

	@Override
	public PedirPlato listarPedirPlatoXID(Long idPedirPlato) {
		return iPedirPlatoDAO.findById(idPedirPlato).get();
	}

	@Override
	public PedirPlato actualizarPedirPlato(PedirPlato pedirPlato) {
		return iPedirPlatoDAO.save(pedirPlato);
	}

	@Override
	public void eliminarPedirPlato(Long idPedirPlato) {
		iPedirPlatoDAO.deleteById(idPedirPlato);

	}

}
