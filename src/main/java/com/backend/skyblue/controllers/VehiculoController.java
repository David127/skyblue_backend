package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.VehiculoRequestDto;
import com.backend.skyblue.dto.response.VehiculoResponseDto;
import com.backend.skyblue.mapper.VehiculoMapper;
import com.backend.skyblue.services.VehiculoService;
import com.backend.skyblue.utils.SysHttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/vehiculo")
public class VehiculoController {
	@Autowired
	private VehiculoService vehiculoService;

	@PostMapping(path = "/listar")
	public ResponseEntity<PageResponseDto> listarVehiculos(
			@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(name = "pageSize", defaultValue = "1", required = false) Integer pageSize
	) {
		var pageable = PageRequest.of(page - VehiculoMapper.PAGINATION_OFFSET, pageSize);
		return new ResponseEntity(vehiculoService.listarVehiculosEnPaginas(pageable), HttpStatus.OK);
	}

	@PostMapping(path = "registrar")
	public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody VehiculoRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (vehiculoService.existeVehiculo(request))
				throw new Exception("El vehiculo ya esta registrado");
			VehiculoResponseDto objSalida = vehiculoService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Registro exitoso", request.getPlaca()); // getTerminal en Viaje
			if (objSalida == null)
				throw new Exception("No se pudo registrar el vehiculo");
			salida.put("data", response);

		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}
		return new ResponseEntity<>(salida, HttpStatus.CREATED);
	}

	@PostMapping(path = "actualizar")
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody VehiculoRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (request.getId() == null || request.getId() == 0)
				throw new Exception("Necesitamos el id del vehiculo para ser actualizado");
			VehiculoResponseDto objSalida = vehiculoService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizado Exitosamente", request.getPlaca()); // getTerminal en Viaje
			if(objSalida == null)
				throw  new Exception("No se pudo actulizar el vehiculo");
			salida.put("data",response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}
		return new ResponseEntity<>(salida, HttpStatus.OK);
	}





}
