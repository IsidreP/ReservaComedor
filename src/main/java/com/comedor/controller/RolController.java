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

	@GetMapping("/roles")
	public List<Rol> listarRoles() {
		return rolServiceImpl.listarRoles();
	}

	@PostMapping("/roles")
	public Rol guardarRol(@RequestBody Rol rol) {
		return rolServiceImpl.guardarRol(rol);
	}

	@GetMapping("/roles/{idRol}")
	public Rol listarRolPorId(@PathVariable(name = "idRol") Long idRol) {

		Rol RolPorId = new Rol();
		RolPorId = rolServiceImpl.listarRolXID(idRol);
		return RolPorId;
	}

	@PutMapping("/roles/{idRol}")
	public Rol actualizarRol(@RequestBody Rol rol, @PathVariable(name = "idRol") Long idRol) {

		Rol rolSeleccionado = new Rol();
		Rol rolActualizado = new Rol();

		// obtenemos Rol de la DB
		rolSeleccionado = rolServiceImpl.listarRolXID(idRol);

		// seteamos nuevos valores
		rolSeleccionado.setIdRol(rol.getIdRol());
		rolSeleccionado.setNombreRol(rol.getNombreRol());

		// actualizamos Rol en la DB
		rolActualizado = rolServiceImpl.actualizarRol(rolSeleccionado);
		return rolActualizado;
	}

	@DeleteMapping("/roles/{idRol}")
	public void eliminarRol(@PathVariable(name = "idRol") Long idRol) {
		rolServiceImpl.eliminarRol(idRol);
	}

}
