package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.mapper.EmpresaMapper;
import com.backend.skyblue.services.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}
