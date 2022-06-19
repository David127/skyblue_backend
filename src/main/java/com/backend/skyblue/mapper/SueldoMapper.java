package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.SueldoRequestDto;
import com.backend.skyblue.dto.response.SueldoResponseDto;
import com.backend.skyblue.models.Sueldo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface SueldoMapper {

    static Set<SueldoResponseDto> buildSuedoResponseSet(Set<Sueldo> sueldos) {
        return sueldos.stream()
                // .sorted(Comparator.comparing(Sueldo::getFkTrabajador))
                .map(SueldoMapper::buildResponseDtoFromEntity)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    static SueldoResponseDto buildResponseDtoFromEntity(Sueldo sueldo) {
        return SueldoResponseDto.builder()
                .id(sueldo.getId())
                .turno(sueldo.getTurno())
                .meses(sueldo.getMeses())
                .anio(sueldo.getAnio())
                .Base(sueldo.getBase())
                .build();
    }


    static List<Sueldo> buildSueldosList(Set<SueldoRequestDto> sueldos) {
        List<Sueldo> listSueldo = new ArrayList<>();
        for (SueldoRequestDto lstSueld : sueldos) {
            Sueldo sueldo = buildEntityRequestDto(lstSueld);
            listSueldo.add(sueldo);
        }
        return listSueldo;
    }

    static Sueldo buildEntityRequestDto(SueldoRequestDto sueldo) {
        return Sueldo.builder()
                .id(sueldo.getId())
                .base(sueldo.getBase())
                .turno(sueldo.getTurno())
                .anio(sueldo.getAnio())
                .meses(sueldo.getMeses())
                .build();
    }
}




