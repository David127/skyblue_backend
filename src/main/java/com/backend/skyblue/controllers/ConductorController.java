package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.ConductorRequestDto;
import com.backend.skyblue.dto.response.ConductorResponseDto;
import com.backend.skyblue.mapper.ConductorMapper;
import com.backend.skyblue.services.ConductorService;
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
@RequestMapping("/conductor")
public class ConductorController {
	private final ConductorService conductorService;

	@PostMapping(path = "/listar")
	public ResponseEntity<PageResponseDto> listarConductores(
			@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(name = "pageSize", defaultValue = "1", required = false) Integer pageSize
	) {
		var pageable = PageRequest.of(page - ConductorMapper.PAGINATION_OFFSET, pageSize);
		return new ResponseEntity(conductorService.listarConductorEnPaginas(pageable), HttpStatus.OK);
	}

	@PostMapping(path = "registrar")
	public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody ConductorRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (conductorService.existeConductor(request))
				throw new Exception("El conductor " + request.getNombre() + " ya existe");
			ConductorResponseDto objSalida = conductorService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Registro exitoso", objSalida.getNombre() + " " + objSalida.getApellidoPaterno());
			if (objSalida == null)
				throw new Exception("No se pudo registrar el conductor");
			salida.put("data", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}

		return new ResponseEntity<>(salida, HttpStatus.CREATED);
	}

	@PutMapping(path = "actualizar")
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody ConductorRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (request.getId() == null || request.getId() == 0)
				throw new Exception("Necesitamos un Id para porder actualizar el conductor");
			ConductorResponseDto objSalida = conductorService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizado exitoso", objSalida.getNombre() + " " + objSalida.getApellidoPaterno());
			if (objSalida == null)
				throw new Exception("No se pudo Actualizar el Conductor");
			salida.put("data", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}

		return new ResponseEntity<>(salida, HttpStatus.OK);
	}
}
