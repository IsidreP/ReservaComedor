package com.comedor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comedor.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Long> {

}
