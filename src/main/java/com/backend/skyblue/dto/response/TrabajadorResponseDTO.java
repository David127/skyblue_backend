package com.backend.skyblue.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrabajadorResponseDTO {
    @Serial
    private static final long serialVersionUID = 1L;
   private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private String nroDocumento;
    private String telefono;
    private String correo;
    private String direccion;
    private String sexo;
    private String estadoCivil;
    private String fechaNacimiento;
    private String fechaIngreso;
    private String fechaSalida;
    private String observacion;
//    private String estado;
    // private UbigeoDTO ubigeo;
   // private CargoDTO cargo;
    private Set<SueldoResponseDto> sueldo;


}
