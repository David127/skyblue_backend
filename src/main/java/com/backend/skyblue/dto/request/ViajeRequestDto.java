package com.backend.skyblue.dto.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViajeRequestDto  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String horaRegistro;
    private String horaSalida;
    private String horaLlegada;
    private Double nroVueltas;
    private String fecha;
    private String terminal;
    private VehiculoRequestDto vehiculo;
    private ConductorRequestDto conductor;
}
