package com.comedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.comedor.dao.IUsuarioDAO;
import com.comedor.dto.Usuario;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private IUsuarioDAO iUsuarioDAO;
//
//	public UsuarioDetailsServiceImpl(IUsuarioDAO iUsuarioDAO) {
//		this.iUsuarioDAO = iUsuarioDAO;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
	}

}
