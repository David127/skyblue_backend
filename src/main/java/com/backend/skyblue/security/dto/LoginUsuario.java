package com.backend.skyblue.security.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class LoginUsuario {
	
	@NotBlank
	private String nombreUsuario;
	@NotBlank
	private String password;
}
