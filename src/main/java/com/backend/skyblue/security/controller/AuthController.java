package com.backend.skyblue.security.controller;

import com.backend.skyblue.security.dto.JwtDto;
import com.backend.skyblue.security.dto.LoginUsuario;
import com.backend.skyblue.security.dto.NuevoUsuario;
import com.backend.skyblue.security.entity.Rol;
import com.backend.skyblue.security.entity.Usuario;
import com.backend.skyblue.security.enums.RolNombre;
import com.backend.skyblue.security.jwt.JwtProvider;
import com.backend.skyblue.security.service.RolService;
import com.backend.skyblue.security.service.UsuarioSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")

@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UsuarioSevice usuarioSevice;
	@Autowired
	RolService rolService;
	@Autowired
	JwtProvider jwtProvider;

	// @PreAuthorize("hasRole('ADMIN')")
	@PostMapping(path = "/nuevo",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
	)
	public ResponseEntity<?> nuevo(@Valid NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity("Campos mal puestos o email invalido", HttpStatus.BAD_REQUEST);

		if (usuarioSevice.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity("Ese nombre ya existe", HttpStatus.BAD_REQUEST);

		if (usuarioSevice.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity("Ese email ya existe", HttpStatus.BAD_REQUEST);

		Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
				passwordEncoder.encode(nuevoUsuario.getPassword()));

		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());

		usuario.setRoles(roles);
		usuarioSevice.save(usuario);
		return new ResponseEntity("usuario Guardado", HttpStatus.BAD_REQUEST.CREATED);
	}

	@PostMapping(path = "/login",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
	)
	public ResponseEntity<JwtDto> login(@Valid LoginUsuario loginUsuario, BindingResult bindingResult) {
		boolean estado = usuarioSevice.existsByNombreUsuario(loginUsuario.getNombreUsuario());
		if (estado == false) {
			return new ResponseEntity("El usuario o contraseña no validos", HttpStatus.BAD_REQUEST);
		}
		if (bindingResult.hasErrors())
			return new ResponseEntity("campos mal puestos", HttpStatus.BAD_REQUEST);
		Authentication authentication =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}


}
