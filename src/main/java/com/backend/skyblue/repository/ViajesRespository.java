package com.backend.skyblue.repository;

import com.backend.skyblue.models.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajesRespository extends JpaRepository<Viaje,Long>, JpaSpecificationExecutor<Viaje> {
}
