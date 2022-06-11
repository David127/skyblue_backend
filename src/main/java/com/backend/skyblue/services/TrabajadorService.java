package com.backend.skyblue.services;

import com.backend.skyblue.dto.response.TrabajadorPageResponseDTO;
import com.backend.skyblue.mapper.TrabajadorMappers;
import com.backend.skyblue.models.Sueldo;
import com.backend.skyblue.models.Trabajador;
import com.backend.skyblue.repository.TrabajadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class TrabajadorService  {

    private final TrabajadorRepository trabajadorRepository;

    private final SueldoService sueldoService;


    public Page<Trabajador> listarEnPaginas(String estado, Pageable pageable) {
       return trabajadorRepository.listarEnPaginas(estado,pageable);
    }


    public Optional<Trabajador> listarPorId(long id) {
        return trabajadorRepository.findById(id);
    }


    public List<Trabajador> listarTodos() {
        var trabajador = trabajadorRepository.findAll();
        //var sueldo = sueldoRepository.findAll();

        //var sueldos = sueldoRepository.findAll();



       return  null;
    }

    public boolean existeTrabajador(Trabajador obj) {
        return  trabajadorRepository.existsById(obj.getId());
    }

    public Trabajador insertar(Trabajador obj){

        return obj;
    }

    public Trabajador actualizar(Trabajador obj){
        if(obj == null)
            throw new IllegalArgumentException ("El objeto Trabajador no puede ser nulo");
        return  trabajadorRepository.save(obj);
    }

    public Trabajador insertarActualizar(Trabajador obj) {

        if(existeTrabajador(obj)){
            return actualizar(obj);
        }else{
            return  save(obj);
        }

    }

    @Transactional
    public Trabajador save(Trabajador trabajador){

        var trabajadorSaved = trabajadorRepository.saveAndFlush(trabajador);
        findAndSueldosToTrabajador(trabajadorSaved);
        return trabajadorSaved;
    }



    @Transactional
    private void findAndSueldosToTrabajador(Trabajador trabajador) {
        Set<Sueldo> sueldos = sueldoService.findAllByTrabajadorId(trabajador.getId());
        trabajador.setSueldo(sueldos);
    }

    public TrabajadorPageResponseDTO findTrabajadorByFilter(Pageable pageable) {
       // Specification<Trabajador> trabajadorEspecificacion =
        Page<Trabajador>  trabajadorFoud =  trabajadorRepository.findAll(pageable);
        return  TrabajadorMappers.buildTrabajadorPageResponseDto(trabajadorFoud);
    }


    /*public TrabajadorResponseDTO create(TrabajadorRequestDto request) {
        //TrabajadorResponseDTO  trabajadorResponseDTO = findTrabajadorById(request.getId());
        TrabajadorResponseDTO  trabajadorResponseDTO;
        trabajadorResponseDTO = createNewTrabajador(request)
    }

    private TrabajadorResponseDTO createNewTrabajador(TrabajadorRequestDto request) {
        return
    }*/
}
