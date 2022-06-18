package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.SueldoRequestDto;
import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.models.Trabajador;

import java.util.Set;

public class TrabajadorCreateBuilder {
    private Trabajador trabajador;
    private TrabajadorRequestDto trabajadorRequestDto;

    public TrabajadorCreateBuilder listSueldos(Set<SueldoRequestDto> sueldos) {
        trabajador.addSueldos(SueldoMapper.buildSueldosList(sueldos));
        return this;
    }

    public TrabajadorCreateBuilder trabajadorDto(TrabajadorRequestDto trabajadorRequestDto) {
        this.trabajadorRequestDto = trabajadorRequestDto;
        trabajador = TrabajadorMapper.buildEntidadFromDto(trabajadorRequestDto);
        return this;
    }


    public Trabajador build() {
        return trabajador;
    }

}
