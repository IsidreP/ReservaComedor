package com.comedor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comedor.dto.Rol;

public interface IRolDAO extends JpaRepository<Rol, Long>{
		
}
