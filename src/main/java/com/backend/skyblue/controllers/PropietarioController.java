package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.PropietarioRequestDto;
import com.backend.skyblue.dto.response.PropietarioResponseDto;
import com.backend.skyblue.mapper.PropietarioMapper;
import com.backend.skyblue.services.PropietarioService;
import com.backend.skyblue.utils.SysHttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@AllArgsConstructor
@Validated
@RequestMapping("/propietario")
public class PropietarioController {
	private final PropietarioService propietarioService;

	@PostMapping(path = "/listar")
	public ResponseEntity<PageResponseDto> listarPropietarios(
			@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(name = "pageSize", defaultValue = "1", required = false) Integer pageSize
	) {
		var pageable = PageRequest.of(page - PropietarioMapper.PAGINATION_OFFSET, pageSize);
		return new ResponseEntity(propietarioService.listarPropietarioEnPaginas(pageable), HttpStatus.OK);
	}

	@PostMapping(path = "registrar")
	public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody PropietarioRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (propietarioService.existePropietario(request))
				throw new Exception("El propietario " + request.getNombre() + " ya existe");
			PropietarioResponseDto objSalida = propietarioService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Registro exitoso", objSalida.getNombre() + " " + objSalida.getApellidoPaterno());
			if (objSalida == null)
				throw new Exception("No se pudo registrar el propietario");
			salida.put("data", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}

		return new ResponseEntity<>(salida, HttpStatus.CREATED);
	}

	@PutMapping(path = "actualizar")
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody PropietarioRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (request.getId() == null || request.getId() == 0)
				throw new Exception("Necesitamos un Id para porder actualizar el propietario");
			PropietarioResponseDto objSalida = propietarioService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizado exitoso", objSalida.getNombre() + " " + objSalida.getApellidoPaterno());
			if (objSalida == null)
				throw new Exception("No se pudo Actualizar el Propietario");
			salida.put("data", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}

		return new ResponseEntity<>(salida, HttpStatus.OK);
	}
}

