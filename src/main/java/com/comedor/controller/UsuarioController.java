package com.comedor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.comedor.dto.Usuario;
import com.comedor.service.UsuarioServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return usuarioServiceImpl.listarUsuarios();
	}

	// crear nuevo usuario
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return usuarioServiceImpl.guardarUsuario(usuario);
	}
	

	// listar usuario por id
	@GetMapping("/usuarios/{id}")
	public Usuario listarUsuarioPorId(@PathVariable(name = "id") Long idUsuario) {

		Usuario usuarioPorId = new Usuario();
		usuarioPorId = usuarioServiceImpl.listarUsuarioXID(idUsuario);
		return usuarioPorId;
	}

	// actualizar usuario
	@PutMapping("/usuarios/{id}")
	public Usuario actualizarUsuario(@RequestBody Usuario usuario, @PathVariable(name = "id") Long idUsuario) {

		Usuario usuarioSeleccionado = new Usuario();
		Usuario usuarioActualizado = new Usuario();

		// obtenemos usuario de la DB
		usuarioSeleccionado = usuarioServiceImpl.listarUsuarioXID(idUsuario);

		// seteamos nuevos valores
		usuarioSeleccionado.setId(usuario.getId());
		usuarioSeleccionado.setUsername(usuario.getUsername());
		usuarioSeleccionado.setEmail(usuario.getEmail());
		usuarioSeleccionado.setPassword(usuario.getPassword());
		usuarioSeleccionado.setRol(usuario.getRol());
		usuarioSeleccionado.setPedirPlato(usuario.getPedirPlato());

		// actualizamos usuario en la DB
		usuarioActualizado = usuarioServiceImpl.actualizarUsuario(usuarioSeleccionado);
		return usuarioActualizado;
	}

	// eliminar usuario por id
	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable(name = "id") Long idUsuario) {
		usuarioServiceImpl.eliminarUsuario(idUsuario);
	}

}

