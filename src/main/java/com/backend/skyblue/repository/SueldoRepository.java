package com.backend.skyblue.repository;


import com.backend.skyblue.dtos.Sueldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SueldoRepository extends JpaRepository<Sueldo,Long> {
}
