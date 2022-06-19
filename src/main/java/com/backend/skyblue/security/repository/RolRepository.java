package com.backend.skyblue.security.repository;

import com.backend.skyblue.security.entity.Rol;
import com.backend.skyblue.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository  extends JpaRepository<Rol,Integer> {
    Optional<Rol>findByRolNombre(RolNombre rolNombre);
    
}
