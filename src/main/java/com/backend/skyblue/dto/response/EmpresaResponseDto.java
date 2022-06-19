package com.backend.skyblue.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaResponseDto implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private Long id;
	private String ruc;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	private String logo;
	private UbigeoResponseDto ubigeo;
	private RutaResponseDto ruta;
}
