package com.backend.skyblue.dto.request;

import com.backend.skyblue.models.Ruta;
import lombok.*;

import javax.validation.constraints.NotNull;
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
    @NotNull(message = "La placa no puede ser vacio")
    private String placa;
    @NotNull(message = "El padron no puede ser vacio")
    private String padron;
    private String clase;
    @NotNull(message = "La marca no puede ser vacio")
    private String marca;
    @NotNull(message = "El modelo no puede ser vacio")
    private String modelo;
    private String color;
    @NotNull(message = "El tipo no puede ser vacio")
    private String tipo;
    @NotNull(message = "La tarjeta de propiedad no puede ser vacio")
    private String tarjetaPropiedad;
    private String anioFabricacion;
    private String nroMoto;
    private Double pesoNeto;
    private Double pesoBruto;
    private Integer nroAsientos;
    @NotNull(message = "El numero de pasajeros no puede ser vacio")
    private Integer nroPasajeros;
    @NotNull(message = "el tipo de combustible no puede ser vacio")
    private Integer tipoCombustible;
    private String carroceria;
    @NotNull(message = "El numero de serie no puede ser vacio")
    private String SerieMotor;
    private Integer nroCilindros;
    private Integer nroRuedas;
    private Double longitud;
    private Double altura;
    private Double ancho;
    private Double cargaUtil;
    private Integer nroEjes;
    private Double kilomentraje;
    @NotNull
    private RutaRequestDto ruta;

}
