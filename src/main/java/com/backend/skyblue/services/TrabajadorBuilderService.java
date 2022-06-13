package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.models.Trabajador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TrabajadorBuilderService {
    public Trabajador buildNewTrabajador(TrabajadorRequestDto trabajadorRequestDto){
        var sueldos = trabajadorRequestDto.getSueldos();

       return  Trabajador.createBuilder()
               .trabajadorDto(trabajadorRequestDto)
                .listSueldos(sueldos)
                .build();

    }


}
