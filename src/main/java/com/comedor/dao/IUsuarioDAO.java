package com.comedor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comedor.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);
}