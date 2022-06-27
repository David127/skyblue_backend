package com.backend.skyblue.dto.request;

import lombok.*;
import org.hibernate.engine.spi.ManagedEntity;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViajeRequestDto  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull(message = "La hora de registro no puede ser vacio")
    private String horaRegistro;
    private String horaSalida;
    private String horaLlegada;
    private Double nroVueltas;
    private String fecha;
    @NotNull(message = "El terminal no puede ser vacio")
    private String terminal;
    @NotNull(message = "El vehiculo no puede ser vacio")
    private VehiculoRequestDto vehiculo;
    @NotNull(message = "El Conductor no puede ser vacio")
    private ConductorRequestDto conductor;
}
