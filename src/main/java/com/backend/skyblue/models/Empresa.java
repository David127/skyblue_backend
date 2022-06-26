package com.backend.skyblue.models;

import com.backend.skyblue.mapper.EmpresaCreateBuilder;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Table(name = "empresa")
@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Empresa implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ruc;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	private String logo;
	@OneToOne
	@JoinColumn(name = "ubigeo_id")
	private Ubigeo ubigeo;
	@OneToOne
	@JoinColumn(name = "ruta_id")
	private Ruta ruta;

	public static EmpresaCreateBuilder createBuilder() {
		return new EmpresaCreateBuilder();
	}
}
