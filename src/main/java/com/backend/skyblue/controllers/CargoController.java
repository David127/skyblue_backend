package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.CargoRequestDto;
import com.backend.skyblue.dto.response.CargoResponseDto;
import com.backend.skyblue.mapper.CargoMapper;
import com.backend.skyblue.services.CargoService;
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
@RequestMapping("/cargo")
public class CargoController {
	private final CargoService cargoService;

	@PostMapping(path = "/listar")
	public ResponseEntity<PageResponseDto> listarCargos(
			@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(name = "pageSize", defaultValue = "1", required = false) Integer pageSize
	) {
		var pageable = PageRequest.of(page - CargoMapper.PAGINATION_OFFSET, pageSize);
		return new ResponseEntity<>(cargoService.listarCargoEnPaginas(pageable), HttpStatus.OK);
	}

	@PostMapping(path = "registrar")
	public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody CargoRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (cargoService.existeCargo(request))
				throw new Exception("El cargo ya existe");
			CargoResponseDto objSalida = cargoService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Registro exitoso", request.getNombre());
			if (objSalida == null)
				throw new Exception("No se pudo registrar el cargo");
			salida.put("data", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}
		return new ResponseEntity<>(salida,HttpStatus.CREATED);

	}

	@PutMapping(path = "actualizar")
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody CargoRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (request.getId() == null || request.getId() == 0)
				throw new Exception("Necesitamos el id del viaje para ser actulizado");
			CargoResponseDto objSalida = cargoService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizado Exitosamente", request.getNombre());
			if (objSalida == null)
				throw new Exception("No se pudo actulizar el viaje");
			salida.put("data", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}
		return new ResponseEntity<>(salida, HttpStatus.OK);
	}

}
