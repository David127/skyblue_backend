package com.backend.skyblue.security.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nombre;
	@NotNull
	@Column(unique = true)
	private String nombreUsuario;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name = "usuario_id"),inverseJoinColumns = @JoinColumn(name ="rol_id"))
	private Set<Rol> roles = new HashSet<Rol>();

	public Usuario(){
		
	}
	public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
			@NotNull String password) {
		this.nombre 		= nombre;
		this.nombreUsuario  = nombreUsuario;
		this.email			= email;
		this.password		= password;
		
	}



}
