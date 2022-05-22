package com.comedor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comedor.dto.Plato;

public interface IPlatoDAO extends JpaRepository<Plato, Integer> {

}
