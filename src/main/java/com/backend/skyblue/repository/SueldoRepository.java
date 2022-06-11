package com.backend.skyblue.repository;


import com.backend.skyblue.models.Sueldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SueldoRepository extends JpaRepository<Sueldo,Long> {

    Set<Sueldo> findByFkTrabajador(Long id);

}
