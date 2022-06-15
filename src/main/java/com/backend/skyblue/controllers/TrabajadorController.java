package com.backend.skyblue.controllers;

import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.dto.response.TrabajadorPageResponseDTO;
import com.backend.skyblue.dto.response.TrabajadorResponseDTO;
import com.backend.skyblue.mapper.TrabajadorMappers;
import com.backend.skyblue.models.Trabajador;
import com.backend.skyblue.services.TrabajadorService;
import com.backend.skyblue.utils.SysHttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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

    @PostMapping("actualizar")
    public ResponseEntity<Map<String, Object>> trabajadorActualizar(@RequestBody Trabajador obj){
        Map<String, Object> salida = new HashMap<>();
        try {
            if(obj.getNombre().equals(""))
                throw new Exception("El nombre es obligatorio");
            Optional<Trabajador> lista;
            Trabajador objSalida = null;
                    //trabajadorService.insertarActualizar(obj);
            SysHttpResponse response = null;
                    //new SysHttpResponse(HttpStatus.OK.value(), "Actualizado exitoso",objSalida);
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
        return new ResponseEntity(trabajadorService.findTrabajadorByFilter(pageable),HttpStatus.OK);
    }

       @PostMapping("registrar")
    public ResponseEntity<Map<String,Object>> registrar(@RequestBody TrabajadorRequestDto request){
           Map<String, Object> salida = new HashMap<>();
        try {
            if(trabajadorService.existeTrabajador(request))
                throw  new Exception("El trabajar " + request.getNombre() + "ya existe");
            TrabajadorResponseDTO objSalida = trabajadorService.insertarActualizar(request);
            SysHttpResponse response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizado exitoso",objSalida);
            if(objSalida == null)
                throw new Exception("No se pudo Actualizar el Trabajador");
            salida.put("response",response);
        }catch(Exception e){
            SysHttpResponse response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),null);
            salida.put("data",response);
        }

           return new ResponseEntity<>(salida, HttpStatus.CREATED);
        }

}
