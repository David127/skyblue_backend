package com.backend.skyblue.controllers;

import com.backend.skyblue.dtos.Vehiculo;
import com.backend.skyblue.services.VehiculoService;
import com.backend.skyblue.utils.SysHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping( path = "/listar",
    consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    ResponseEntity<Page<Vehiculo>> vehiculoListar(
            @RequestParam(defaultValue = "activo") String estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean asc){

        Page<Vehiculo> listVehiculos = vehiculoService.listarEnPaginas( estado, PageRequest.of(page, size ));
        SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Listado exitoso",listVehiculos);
        if(!asc)
            vehiculoService.listarEnPaginas( estado, PageRequest.of(page, size));
        return  new ResponseEntity( response, HttpStatus.OK);
    }

}
