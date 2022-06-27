package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.UbigeoRequestDto;
import com.backend.skyblue.dto.response.UbigeoResponseDto;
import com.backend.skyblue.models.Ubigeo;

import java.util.List;
import java.util.stream.Collectors;

public interface UbigeoMapper {
    static UbigeoResponseDto builResponseDto(Ubigeo ubigeo) {

        return UbigeoResponseDto.builder()
                .id(ubigeo.getId())
                .departamento(ubigeo.getDepartamento())
                .provincia(ubigeo.getProvincia())
                .distrito(ubigeo.getDistrito())
                .build();
    }

    static List<UbigeoResponseDto> buildListResponseEntities(List<String> ubigeo){
        return ubigeo.stream()
                .map( ub->UbigeoMapper.builDepartamentoDto(ub))
                .collect(Collectors.toList());
    }

    static UbigeoResponseDto builDepartamentoDto(String ub) {
        return UbigeoResponseDto.builder()
                .departamento(ub)
                .build();
    }

    static Ubigeo buildRequestDto(UbigeoRequestDto ubigeo) {

        return Ubigeo.builder()
                .id(ubigeo.getId())
                .departamento(ubigeo.getDepartamento())
                .provincia(ubigeo.getProvincia())
                .distrito(ubigeo.getDistrito())
                .build();
    }
}
