package com.comedor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import comedor.dto.Usuario;


public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{
	
}