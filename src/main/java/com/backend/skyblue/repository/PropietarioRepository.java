package com.backend.skyblue.repository;

import com.backend.skyblue.models.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PropietarioRepository extends JpaRepository<Propietario, Long>, JpaSpecificationExecutor<Propietario> {

}

