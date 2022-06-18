package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.services.ViajesService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.backend.skyblue.mapper.TrabajadorMapper.PAGINATION_OFFSET;

@RestController
@CrossOrigin
@AllArgsConstructor
@Validated
@RequestMapping("/viaje")
public class ViajeController {
	private final ViajesService viajesService;

	@PostMapping(path = "/listar")
	public ResponseEntity<PageResponseDto> listarViajes(
			@RequestParam(name = "page",defaultValue = "1",required = false)Integer page,
			@RequestParam(name = "page",defaultValue = "1",required = false)Integer pageSize
	){
		var pageable = PageRequest.of(page - PAGINATION_OFFSET, pageSize);
		return new ResponseEntity(viajesService.listarVehiculoEnPaginas(pageable), HttpStatus.OK);
	}

}
