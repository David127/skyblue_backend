package com.backend.skyblue.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serial;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequestDto {
	@Serial
	private static  final long serialVersionUID  = 1L;
	private Long id;
	private String ruc;
	private String nombre;
	private String direccion;
	private String telefono;
	@Email(message = "Error ene el formato del correo")
	private String correo;
	private String logo;
	@NotNull(message = "El ubigeo no debe ser vacio")
	private UbigeoRequestDto ubigeo;
	@NotNull(message = "La ruta no debe ser vacio")
	private RutaRequestDto ruta;
}
