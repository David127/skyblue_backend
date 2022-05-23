package com.backend.skyblue.dtos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
@Data
@Entity
@Table(name = "cargo")
public class Cargo  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String responsable;

    
}
