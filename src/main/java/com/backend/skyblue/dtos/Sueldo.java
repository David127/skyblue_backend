package com.backend.skyblue.dtos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sueldo")
public class Sueldo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String turno;
    private Integer dias;
    private Integer mesess;
    private Double horasExtras;
    private Double Base;
    private Double dolares;
    private Double soles;
    private Double total;
    
}
