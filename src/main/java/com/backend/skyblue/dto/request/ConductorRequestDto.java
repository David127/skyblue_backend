package com.backend.skyblue.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConductorRequestDto implements Serializable {
    @Serial
    private static  final long serialVersionUID  = 1L;
    private Long id;
    @NotBlank(message = "El nombre no puede ser vacio")
    @Size(min=1, max=16)
    private String nombre;
    @NotNull(message = "El apellido no puede ser vacio")
    private String apellidoPaterno;
    @NotNull (message = "El apellido no puede ser vacio")
    private String apellidoMaterno;
    private String tipoDocumento;
    @NotNull (message = "El el numero de documento no puedo ser vacio")
    private String nroDocumento;
    private String telefono;
    @Email(message = "Error ene el formato del correo")
    private String correo;
    @NotNull (message = "La direccion no puede ser vacio")
    private String direccion;
    private String sexo;
    private String estadoCivil;
    private String fechaNacimiento;
    private String observacion;
    private String estado;
    @NotNull (message = "El numero de licencia correlativo no puede ser vacio")
    private String nroLicenciaCorrelativo;
    @NotNull(message = "la clase categoria no puede ser vacio")
    private String claseCategoria;
    @NotNull(message = "El estado de licencia no puede ser vacio")
    private String estadoLicencia;
    private String fechaExpedicion;
    private String fechaRevalidacion;
    @NotNull(message = "las restricciones no puede ser vacio")
    private String restricciones;
}
