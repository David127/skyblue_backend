package com.backend.skyblue.repository;


import com.backend.skyblue.models.Sueldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SueldoRepository extends JpaRepository<Sueldo,Long>, JpaSpecificationExecutor<Sueldo> {

  //  Set<Sueldo> findByFkTrabajador(Long id);

}
