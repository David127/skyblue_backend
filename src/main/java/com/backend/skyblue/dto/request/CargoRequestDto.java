package com.backend.skyblue.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoRequestDto implements Serializable {
    @Serial
    private static  final long serialVersionUID  = 1L;
    private Long id;
    @Size(max=25)
    private String nombre;
    @NotNull(message = "La descripcion no puede ser vacio")
    private String descripcion;
    @NotNull(message = "El responsable no puede ser vacio")
    private String responsable;
}
