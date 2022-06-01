package com.comedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comedor.dto.Usuario;
import com.comedor.service.UsuarioServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("")
public class RegistroController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public RegistroController(UsuarioServiceImpl usuarioServiceImpl, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioServiceImpl = usuarioServiceImpl;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PostMapping("/registro")
	public Usuario registrarUsuario(@RequestBody Usuario user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usuarioServiceImpl.guardarUsuario(user);
		return user;
	}
}
