package com.comedor.service;

import java.util.List;
import com.comedor.dto.PedirPlato;

public interface IPedirPlatoService {

	// READ todos pedirPlato
	public List<PedirPlato> listarPedirPlato();

	// CREATE nuevo pedirPlato
	public PedirPlato guardarPedirPlato(PedirPlato pedirPlato);

	// READ pedirPlato por id
	public PedirPlato listarPedirPlatoXID(Long idPedirPlato);

	// UPDATE pedirPlato
	public PedirPlato actualizarPedirPlato(PedirPlato pedirPlato);

	// DELETE pedirPlato
	public void eliminarPedirPlato(Long idPedirPlato);

}
