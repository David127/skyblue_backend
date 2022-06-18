package com.backend.skyblue.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViajeResponseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String horaRegistro;
    private String horaSalida;
    private String horaLlegada;
    private Double nroVueltas;
    private String fecha;
    private String terminal;
    private VehiculoResponseDto vehiculo;
    private ConductorResponseDto conductor;
}
