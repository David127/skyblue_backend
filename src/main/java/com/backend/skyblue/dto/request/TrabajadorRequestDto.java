package com.backend.skyblue.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrabajadorRequestDto   implements Serializable {
    @Serial
    private static  final long serialVersionUID  = 1L;
    private Long id;
    @NotBlank (message = "El nombre no puede ser vacio")
    @Size(min=1, max=16)
    private String nombre;
    @NotNull (message = "El apellido no puede ser vacio")
    private String apellidoPaterno;
    @NotNull (message = "El apellido no puede ser vacio")
    private String apellidoMaterno;
    private String tipoDocumento;
    @NotNull (message = "El el numero de documento no puedo ser vacio")
    private String nroDocumento;
    @NotEmpty(message = "El telefono no puede estar vacio")
    @Size(max = 9)
    private String telefono;
    @Email (message = "Error en el formato del correo")
    private String correo;
    @NotNull (message = "La direccion no puede ser vacio")
    private String direccion;
    private String sexo;
    private String estadoCivil;
    private String fechaNacimiento;
    private String fechaIngreso;
    private String fechaSalida;
    private String observacion;
    private String estado;
    @NotNull(message = "El ubigeo no debe ser vacio")
    private UbigeoRequestDto ubigeo;
    @NotNull(message = "El cargo no debe ser vacio")
    private CargoRequestDto cargo;
    private Set<SueldoRequestDto> sueldos;
}
