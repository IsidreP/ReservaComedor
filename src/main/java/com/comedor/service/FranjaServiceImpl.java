package com.comedor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comedor.dao.IFranjaDAO;
import com.comedor.dto.Franja;

@Service
public class FranjaServiceImpl implements IFranjaService {
	
	@Autowired
	IFranjaDAO iFranjaDAO;

	@Override
	public List<Franja> listarFranjas() {
		return iFranjaDAO.findAll();
	}

	@Override
	public Franja guardarFranja(Franja franja) {
		return iFranjaDAO.save(franja);
	}

	@Override
	public Franja listarFranjaXID(Long idFranja) {
		return iFranjaDAO.findById(idFranja).get();
	}

	@Override
	public Franja actualizarFranja(Franja franja) {
		return iFranjaDAO.save(franja);
	}

	@Override
	public void eliminarFranja(Long idFranja) {
		iFranjaDAO.deleteById(idFranja);
	}

}
