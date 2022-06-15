package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.dto.response.TrabajadorPageResponseDTO;
import com.backend.skyblue.dto.response.TrabajadorResponseDTO;
import com.backend.skyblue.mapper.TrabajadorMappers;
import com.backend.skyblue.models.Trabajador;
import com.backend.skyblue.repository.TrabajadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@AllArgsConstructor
public class TrabajadorService  {

    private final TrabajadorRepository trabajadorRepository;

    private final SueldoService sueldoService;

    private final TrabajadorBuilderService trabajadorBuilderService;

    public Page<Trabajador> listarEnPaginas(String estado, Pageable pageable) {
       return trabajadorRepository.listarEnPaginas(estado,pageable);
    }


    public Optional<Trabajador> listarPorId(long id) {
        return trabajadorRepository.findById(id);
    }



    public boolean existeTrabajador(TrabajadorRequestDto obj) {
        return  trabajadorRepository.existsById(obj.getId());
    }


    public TrabajadorResponseDTO actualizar(TrabajadorRequestDto obj){
        if(obj == null)
            throw new IllegalArgumentException ("El objeto Trabajador no puede ser nulo");
        return null;
    }

    public TrabajadorResponseDTO insertarActualizar(TrabajadorRequestDto obj) {
        if(existeTrabajador(obj)){
           return actualizar(obj);
        }else {
            return create(obj);
        }
    }
    public TrabajadorResponseDTO create(TrabajadorRequestDto request) {
        TrabajadorResponseDTO trabajadorResponseD = createNewTrabajador(request);
        return trabajadorResponseD;
    }
    @Transactional
    public Trabajador save(Trabajador trabajador){
        var trabajadorSaved = trabajadorRepository.saveAndFlush(trabajador);
      // findAndSueldosToTrabajador(trabajadorSaved);
        return trabajadorSaved;
    }



    public TrabajadorPageResponseDTO findTrabajadorByFilter(Pageable pageable) {
       // Specification<Trabajador> trabajadorEspecificacion =
        Page<Trabajador>  trabajadorFoud =  trabajadorRepository.findAll(pageable);
        return  TrabajadorMappers.buildTrabajadorPageResponseDto(trabajadorFoud);
    }



    private TrabajadorResponseDTO createNewTrabajador(TrabajadorRequestDto request) {
        var trabajador = trabajadorBuilderService.buildNewTrabajador(request);
        save(trabajador);
        return  TrabajadorMappers.buildResponseDtoFrontEntity(trabajador);
    }
}
