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
import com.comedor.dto.Rol;
import com.comedor.service.RolServiceImpl;

@RestController
@RequestMapping("/api")
public class RolController {

	@Autowired
	RolServiceImpl rolServiceImpl;

	// listar todos roles
	@GetMapping("/roles")
	public List<Rol> listarRoles() {
		return rolServiceImpl.listarRoles();
	}

	// crear nuevo rol
	@PostMapping("/roles")
	public Rol guardarRol(@RequestBody Rol rol) {
		return rolServiceImpl.guardarRol(rol);
	}

	// listar rol por id
	@GetMapping("/roles/{idRol}")
	public Rol listarRolPorId(@PathVariable(name = "idRol") Long idRol) {

		Rol rolPorId = new Rol();
		rolPorId = rolServiceImpl.listarRolXID(idRol);
		return rolPorId;
	}

	// actualizar rol
	@PutMapping("/roles/{idRol}")
	public Rol actualizarRol(@RequestBody Rol rol, @PathVariable(name = "idRol") Long idRol) {

		Rol rolSeleccionado = new Rol();
		Rol rolActualizado = new Rol();

		// obtenemos rol de la DB
		rolSeleccionado = rolServiceImpl.listarRolXID(idRol);

		// seteamos nuevos valores
		rolSeleccionado.setIdRol(rol.getIdRol());
		rolSeleccionado.setNombreRol(rol.getNombreRol());

		// actualizamos rol en la DB
		rolActualizado = rolServiceImpl.actualizarRol(rolSeleccionado);
		return rolActualizado;
	}
	// eliminar rol por id
	@DeleteMapping("/roles/{idRol}")
	public void eliminarRol(@PathVariable(name = "idRol") Long idRol) {
		rolServiceImpl.eliminarRol(idRol);
	}

}
