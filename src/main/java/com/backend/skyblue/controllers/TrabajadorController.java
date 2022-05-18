package com.backend.skyblue.controllers;

import com.backend.skyblue.dtos.Trabajador;
import com.backend.skyblue.services.TrabajadorService;
import com.backend.skyblue.utils.SysHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/trabajador")
@CrossOrigin
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    @PostMapping("/listar")
    public ResponseEntity<Page<Trabajador>>trabajadorListar(
            @RequestParam(defaultValue = "activo") String estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean asc){
        Page<Trabajador> listTrabajadores = trabajadorService.listarEnPaginas(estado, PageRequest.of(page, size));
        SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Listado exitoso",listTrabajadores);
        if(!asc)
            trabajadorService.listarEnPaginas(estado,PageRequest.of(page,size));
        return new ResponseEntity(response,HttpStatus.OK);
    }
    @PostMapping("/registar")
    public ResponseEntity<Map<String, Object>> trabajadorRegistar(@RequestBody Trabajador obj){
        Map<String, Object> salida = new HashMap<>();
        try {
            if(obj.getNombre().equals(""))
                throw new Exception("El nombre es obligatorio");

            Optional<Trabajador> lista;
              lista = trabajadorService.listarPorId(obj.getId());
           if(lista.isPresent())
                throw new Exception("El Trabajador ya existe");
            Trabajador objSalida = trabajadorService.insertarActualizar(obj);
            SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Registro exitoso",objSalida);
            if(objSalida == null)
                throw new Exception("No se pudo registrar el Trabajador");
            salida.put("response",response);
        }catch( Exception e){
            SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),null);
            salida.put("data",response);
        }
    return new ResponseEntity<>(salida, HttpStatus.CREATED);
    }

}
