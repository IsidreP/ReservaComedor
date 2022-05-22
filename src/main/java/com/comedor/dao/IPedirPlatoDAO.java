package com.comedor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comedor.dto.PedirPlato;

public interface IPedirPlatoDAO extends JpaRepository<PedirPlato, Long> {

}
