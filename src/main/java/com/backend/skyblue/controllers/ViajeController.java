package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.ViajeRequestDto;
import com.backend.skyblue.dto.response.ViajeResponseDto;
import com.backend.skyblue.mapper.VehiculoMapper;
import com.backend.skyblue.services.ViajesService;
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
@RequestMapping("/viaje")
public class ViajeController {
	private final ViajesService viajesService;

	@PostMapping(path = "/listar")
	public ResponseEntity<PageResponseDto> listarViajes(
			@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(name = "pageSize", defaultValue = "1", required = false) Integer pageSize
	) {
		var pageable = PageRequest.of(page - VehiculoMapper.PAGINATION_OFFSET, pageSize);
		return new ResponseEntity(viajesService.listarVehiculoEnPaginas(pageable), HttpStatus.OK);
	}

	@PostMapping(path = "registrar")
	public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody ViajeRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (viajesService.existeViaje(request))
				throw new Exception("La unidad ya se encuentra en ruta");
			ViajeResponseDto objSalida = viajesService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Registro exitoso", request.getTerminal());
			if (objSalida == null)
				throw new Exception("No se pudo registrar el viaje");
			salida.put("data", response);

		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}
		return new ResponseEntity<>(salida, HttpStatus.CREATED);
	}

	@PutMapping(path = "actualizar")
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody ViajeRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (request.getId() == null || request.getId() == 0)
				throw new Exception("Necesitamos el id del viaje para ser actulizado");
			ViajeResponseDto objSalida = viajesService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizado Exitosamente", request.getTerminal());
			if(objSalida == null)
				throw  new Exception("No se pudo actualizar el viaje");
			salida.put("data",response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}
		return new ResponseEntity<>(salida, HttpStatus.OK);
	}


}
