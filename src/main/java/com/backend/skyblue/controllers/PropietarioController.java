package com.backend.skyblue.controllers;

import com.backend.skyblue.models.Propietario;
import com.backend.skyblue.services.PropietarioService;
import com.backend.skyblue.utils.SysHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("listar")
    public List<Propietario> listaPropietario(){
       List<Propietario> listar = propietarioService.listarTodos();
       return listar;
    }

    @PostMapping("registrar")
    public ResponseEntity<Map<String, Object>> propietarioRegistrar(@RequestBody Propietario propietario){

        Map<String, Object> salida = new HashMap<>();
        Propietario objSalida;
        SysHttpResponse response;
        try {
            if (propietario.getNombre().trim().equals(""))
                throw new Exception("El nombre es obligatorio");

            Optional<Propietario> lista;
            lista = propietarioService.listarPorId(propietario.getId());

            if (lista.isPresent()){
                objSalida = propietarioService.actualizar(propietario);
                response = new SysHttpResponse(HttpStatus.OK.value(), "Actualizacion exitoso",objSalida);
            } else {
                objSalida = propietarioService.insertarActualizar(propietario);
                response = new SysHttpResponse(HttpStatus.OK.value(), "Registro exitoso",objSalida);
            }

            if (objSalida == null)
                throw new Exception("No se pudo completar el registro");
            salida.put("response",response);

        } catch (Exception e){
            response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),null);
            salida.put("data",response);

        }
        return new ResponseEntity<>(salida, HttpStatus.CREATED);
    }


    @PostMapping("/eliminar/{id}")
    public String propietarioEliminar(@ModelAttribute("id") Long id){

        propietarioService.eliminar(id);
        return "redirect:/propietario";
    }

    @PostMapping("/eliminarprueba/{id}")
    public ResponseEntity<Map<String, Object>> propietarioEliminarPrueba(@ModelAttribute("id") Long id){
        Map<String, Object> salida = new HashMap<>();
        SysHttpResponse response;
        try {
            Optional<Propietario> lista;
            lista = propietarioService.listarPorId(id);
            if (lista.isPresent()){
                propietarioService.eliminar(id);
                response = new SysHttpResponse(HttpStatus.OK.value(), "Registro eliminado",null);
            } else {
                response = new SysHttpResponse(HttpStatus.OK.value(), "No existe registro con dicho codigo",null);
            }
            salida.put("response",response);
        }catch( Exception e){
            response = new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),null);
            salida.put("data",response);
        }

        return new ResponseEntity<>(salida, HttpStatus.CREATED);
    }
}
