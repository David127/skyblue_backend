package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.EmpresaRequestDto;
import com.backend.skyblue.dto.response.EmpresaResponseDto;
import com.backend.skyblue.mapper.EmpresaMapper;
import com.backend.skyblue.services.EmpresaService;
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
@RequestMapping("/empresa")
public class EmpresaController {
	private final EmpresaService empresaService;

	@PostMapping(path = "/listar")
	public ResponseEntity<PageResponseDto> listarEmpresa(
			@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(name = "pageSize", defaultValue = "1", required = false) Integer pageSize
	) {
		var pageable = PageRequest.of(page - EmpresaMapper.PAGINATION_OFFSET, pageSize);
		return new ResponseEntity(empresaService.listarEmpresaEnPaginas(pageable), HttpStatus.OK);
	}

	@PostMapping(path = "registrar")
	public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody EmpresaRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (empresaService.existeEmpresa(request))
				throw new Exception("El empresa " + request.getNombre() + " ya existe");
			EmpresaResponseDto objSalida = empresaService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Registro exitoso", objSalida.getNombre());
			if (objSalida == null)
				throw new Exception("No se pudo registrar el Empresa");
			salida.put("data", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}

		return new ResponseEntity<>(salida, HttpStatus.CREATED);
	}

	@PutMapping(path = "actualizar")
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody EmpresaRequestDto request) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (request.getId() == null || request.getId() == 0)
				throw new Exception("Necesitamos un Id para porder actualizar la empresa");
			EmpresaResponseDto objSalida = empresaService.insertarActualizar(request);
			SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizado exitoso", objSalida.getNombre());
			if (objSalida == null)
				throw new Exception("No se pudo Actualizar la Empresa");
			salida.put("data", response);
		} catch (Exception e) {
			SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
			salida.put("data", response);
		}

		return new ResponseEntity<>(salida, HttpStatus.OK);
	}
}
