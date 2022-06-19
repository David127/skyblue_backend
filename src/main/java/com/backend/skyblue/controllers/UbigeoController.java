package com.backend.skyblue.controllers;

import com.backend.skyblue.models.Ubigeo;
import com.backend.skyblue.services.UbigeoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@AllArgsConstructor
@Validated
@RequestMapping("/ubigeo")
public class UbigeoController {
	private final UbigeoService ubigeoService;


	@GetMapping("/departamentos")
	public ResponseEntity<List<String>>  listaDepartamentos() {
		return new ResponseEntity<>(ubigeoService.listaDepartamentos(), HttpStatus.OK) ;
	}

	@GetMapping("/provincias/{paramDep}")
	public ResponseEntity<List<String>> listaProvincias(@PathVariable("paramDep") String dep) {
		return new ResponseEntity<>(ubigeoService.listaProvincias(dep),HttpStatus.OK);
	}

	@GetMapping("/distritos/{paramDep}/{paramProv}")
	public ResponseEntity<List<Ubigeo>> listaDistritos(@PathVariable("paramDep") String dep, @PathVariable("paramProv") String prov) {
		return new ResponseEntity<>( ubigeoService.listaDistritos(dep, prov),HttpStatus.OK);
	}

}
