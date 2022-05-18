package com.backend.skyblue.dtos;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name = "trabajador")
public class Trabajador implements Serializable {
    @Serial
    private static final long serialVersionUID = 2658298970323419879L;
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String estado;

}
