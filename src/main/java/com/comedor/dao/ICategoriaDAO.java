package com.comedor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comedor.dto.Categoria;

public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {

}
