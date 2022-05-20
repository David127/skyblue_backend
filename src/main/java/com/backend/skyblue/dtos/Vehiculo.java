package com.backend.skyblue.dtos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Table(name = "vehiculo")
@Entity
@Data
public class Vehiculo  implements Serializable{
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    private Long id ;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private String estado;
}
