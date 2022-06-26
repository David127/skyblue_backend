package com.backend.skyblue.repository;

import com.backend.skyblue.models.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends JpaRepository<Ruta,Long>, JpaSpecificationExecutor<Ruta> {
}
