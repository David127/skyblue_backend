package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.response.SueldoResponseDto;
import com.backend.skyblue.models.Sueldo;

import java.util.*;
import java.util.stream.Collectors;

public interface SueldoMapper {

    static Set<SueldoResponseDto> builSuedoResponseSet(Set<Sueldo> sueldos){
        return sueldos.stream()
                .sorted(Comparator.comparing(Sueldo::getFkTrabajador))
                .map(SueldoMapper::buildPackResponseDtoFromEntity)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    static SueldoResponseDto buildPackResponseDtoFromEntity(Sueldo sueldo){
        return SueldoResponseDto.builder()
                .id(sueldo.getId())
                .soles(sueldo.getSoles())
                .build();
    }


}
