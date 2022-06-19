package com.backend.skyblue.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehiculo")
public class Vehiculo  implements Serializable{
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    private Long id ;
    private String placa;
    private String padron;
    private String clase;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private String tarjetaPropiedad;
    private String anioFabricacion;
    private String nroMoto;
    private Double pesoNeto;
    private Double pesoBruto;
    private Integer nroAsientos;
    private Integer nroPasajeros;
    private Integer tipoCombustible;
    private String carroceria;
    private String SerieMotor;
    private Integer nroCilindros;
    private Integer nroRuedas;
    private Double longitud;
    private Double altura;
    private Double ancho;
    private Double cargaUtil;
    private Integer nroEjes;
    private Double kilomentraje;
/*
    @OneToMany(targetEntity = Ruta.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ruta",referencedColumnName = "id")
    List<Propietario> propietarios;
    private String estado;*/

    @OneToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

}
