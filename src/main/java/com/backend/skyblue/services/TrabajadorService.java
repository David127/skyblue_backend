package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.dto.response.PageResponseDto;
import com.backend.skyblue.dto.response.TrabajadorResponseDto;
import com.backend.skyblue.mapper.TrabajadorMapper;
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

    public TrabajadorResponseDto insertarActualizar(TrabajadorRequestDto obj) {
        if(existeTrabajador(obj)){
           return actualizar(obj);
        }else {
            return create(obj);
        }
    }
    public TrabajadorResponseDto create(TrabajadorRequestDto request) {
        TrabajadorResponseDto trabajadorResponseD = createNewTrabajador(request);
        return trabajadorResponseD;
    }
    @Transactional
    public Trabajador save(Trabajador trabajador){
        var trabajadorSaved = trabajadorRepository.saveAndFlush(trabajador);
      // findAndSueldosToTrabajador(trabajadorSaved);
        return trabajadorSaved;
    }

    public TrabajadorResponseDto actualizar(TrabajadorRequestDto request) {
        if(request == null)
            throw new IllegalArgumentException ("El objeto Trabajador no puede ser nulo");
        if(request.getId()== null)
            throw new IllegalArgumentException ("El id no puede ser nulo");
        TrabajadorResponseDto trabajadorResponseD = createNewTrabajador(request);
        return trabajadorResponseD;
    }


    public PageResponseDto findTrabajadorByFilter(Pageable pageable) {
       // Specification<Trabajador> trabajadorEspecificacion =
        Page<Trabajador>  trabajadorFoud =  trabajadorRepository.findAll(pageable);
        return  TrabajadorMapper.buildTrabajadorPageResponseDto(trabajadorFoud);
    }



    private TrabajadorResponseDto createNewTrabajador(TrabajadorRequestDto request) {
        var trabajador = trabajadorBuilderService.buildNewTrabajador(request);
        save(trabajador);
        return  TrabajadorMapper.buildResponseDtoFrontEntity(trabajador);
    }
}
