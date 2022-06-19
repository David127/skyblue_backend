package com.backend.skyblue.dto.request;

import com.backend.skyblue.models.Ruta;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequestDto  implements Serializable {
    @Serial
    private static  final long serialVersionUID  = 1L;
    private Long id;
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

    private RutaRequestDto ruta;

}
