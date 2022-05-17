package controllers;

import dtos.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import repository.TrabajadorRepository;

import java.util.List;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @GetMapping ("list")
    public List<Trabajador> list(){
        return trabajadorRepository.findAll();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Trabajador>>trabajadorListar(){
        List<Trabajador> listTrabajadores = null;
        System.out.println("listar");
        listTrabajadores = trabajadorRepository.findAll();
        return ResponseEntity.ok(listTrabajadores);

    }
}
