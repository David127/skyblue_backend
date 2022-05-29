package com.backend.skyblue.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Table(name = "ruta")
@Entity
@Data
public class Ruta implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    private Long id;
    private String codigoRuta;
    private String clase;
    private String lugarOrigen;
    private String lugarDestino;
    private Double distaciaIda;
    private Double distaciaVuelta;
}
