package com.backend.skyblue.repository;

import com.backend.skyblue.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo,Long>, JpaSpecificationExecutor<Cargo> {
}
