package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.dto.response.TrabajadorPageResponseDTO;
import com.backend.skyblue.dto.response.TrabajadorResponseDTO;
import com.backend.skyblue.mapper.TrabajadorMappers;
import com.backend.skyblue.models.Trabajador;
import com.backend.skyblue.services.TrabajadorService;
import com.backend.skyblue.utils.SysHttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/trabajador")
@CrossOrigin
@AllArgsConstructor
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

   /* @PostMapping(path = "/listar",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
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
    }*/
/*
    @PostMapping(path = "/listar")
    public List<?> listar(){
        return trabajadorService.listarTodos();
    }*/

    @PostMapping("registrare")
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

    @PostMapping("actualizar")
    public ResponseEntity<Map<String, Object>> trabajadorActualizar(@RequestBody Trabajador obj){
        Map<String, Object> salida = new HashMap<>();
        try {
            if(obj.getNombre().equals(""))
                throw new Exception("El nombre es obligatorio");
            Optional<Trabajador> lista;
            Trabajador objSalida = trabajadorService.insertarActualizar(obj);
            SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizado exitoso",objSalida);
            if(objSalida == null)
                throw new Exception("No se pudo Actualizar el Trabajador");
            salida.put("response",response);
        }catch( Exception e){
            SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),null);
            salida.put("data",response);
        }
        return new ResponseEntity<>(salida, HttpStatus.CREATED);
    }
    @PostMapping(path = "/listar")
    public ResponseEntity<TrabajadorPageResponseDTO> listarTrabajaores(
            @RequestParam(name = "page",defaultValue ="1",required = false)Integer page,
            @RequestParam(name = "pageSize",defaultValue ="1",required = false)Integer pageSize
    ){
        var pageable = PageRequest.of(page - TrabajadorMappers.PAGINATION_OFFSET, pageSize);
        return ResponseEntity.ok(trabajadorService.findTrabajadorByFilter(pageable));
    }

       @PostMapping("registrar")
    public ResponseEntity<TrabajadorResponseDTO> create(@RequestBody TrabajadorRequestDto request){
        TrabajadorResponseDTO response = trabajadorService.create(request);

        return  ResponseEntity.ok(response);
        }


}
