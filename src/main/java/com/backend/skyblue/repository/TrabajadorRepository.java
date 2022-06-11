package com.backend.skyblue.repository;

import com.backend.skyblue.models.Trabajador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository  extends JpaRepository <Trabajador,Long>, JpaSpecificationExecutor<Trabajador> {

    @Query(
            value = "SELECT * FROM trabajador t WHERE t.estado LIKE :estado",
            nativeQuery = true
    )
    Page<Trabajador> listarEnPaginas(@Param("estado") String estado, Pageable pageable);
 
}
