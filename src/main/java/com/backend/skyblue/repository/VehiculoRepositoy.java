package com.backend.skyblue.repository;

import com.backend.skyblue.dtos.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepositoy extends JpaRepository<Vehiculo, Long> {

    @Query(
            value = "SELECT * from vehiculo v WHERE v.estado  LIKE :estado",
            nativeQuery = true
    )

    Page<Vehiculo> listarEnPaginas(@Param("estado") String estado, Pageable pageable);
    
}
