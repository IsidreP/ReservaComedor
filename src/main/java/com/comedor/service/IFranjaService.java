package com.comedor.service;

import java.util.List;

import com.comedor.dto.Franja;

public interface IFranjaService {
	
	// READ todas Franjas
	public List<Franja> listarFranjas();

	// CREATE nueva franja
	public Franja guardarFranja(Franja franja);

	// READ franja por id
	public Franja listarFranjaXID(Long idFranja);

	// UPDATE franja
	public Franja actualizarFranja(Franja franja);

	// DELETE franja
	public void eliminarFranja(Long idFranja);

}

