package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.dto.response.TrabajadorResponseDto;
import com.backend.skyblue.mapper.TrabajadorMapper;
import com.backend.skyblue.services.TrabajadorService;
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
@RequestMapping("/trabajador")
public class TrabajadorController {
	private final TrabajadorService trabajadorService;

	@PostMapping(path = "/listar")
	public ResponseEntity<PageResponseDto> listarTrabajaores(
			@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(name = "pageSize", defaultValue = "1", required = false) Integer pageSize
	) {
		var pageable = PageRequest.of(page - TrabajadorMapper.PAGINATION_OFFSET, pageSize);
		return new ResponseEntity(trabajadorService.listarTrabajadorEnPaginas(pageable), HttpStatus.OK);
	}

	@PostMapping("registrar")
	public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody TrabajadorRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (trabajadorService.existeTrabajador(request))
				throw new Exception("El trabajar " + request.getNombre() + " ya existe");
			TrabajadorResponseDto objSalida = trabajadorService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Registro exitoso", objSalida.getNombre() + " " + objSalida.getApellidoMaterno());
			if (objSalida == null)
				throw new Exception("No se pudo registrar el trabajador");
			salida.put("response", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}

		return new ResponseEntity<>(salida, HttpStatus.CREATED);
	}


	@PostMapping("actualizar")
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody TrabajadorRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (request.getId() == null)
				throw new Exception("Necesitamos un Id para porder actualizar el trabajador");
			TrabajadorResponseDto objSalida = trabajadorService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizado exitoso", objSalida.getNombre() + " " + objSalida.getApellidoMaterno());
			if (objSalida == null)
				throw new Exception("No se pudo Actualizar el Trabajador");
			salida.put("response", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}

		return new ResponseEntity<>(salida, HttpStatus.CREATED);
	}
}
