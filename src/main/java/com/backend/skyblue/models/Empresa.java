package com.backend.skyblue.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Table(name = "empresa")
@Entity
@Data
public class Empresa implements Serializable {
	@Serial
	private static final long serialVersionUID = 2L;
	@Id
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
}
