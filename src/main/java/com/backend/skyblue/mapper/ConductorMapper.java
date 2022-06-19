package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.ConductorRequestDto;
import com.backend.skyblue.dto.response.ConductorResponseDto;
import com.backend.skyblue.models.Conductor;

public interface ConductorMapper {
     static ConductorResponseDto buildResponseDto(Conductor conductor) {

        return ConductorResponseDto.builder()
                .id(conductor.getId())
                .nombre(conductor.getNombre())
                .apellidoPaterno(conductor.getApellidoPaterno())
                .apellidoMaterno(conductor.getApellidoMaterno())
                .build();
    }

     static Conductor buildRequestDto(ConductorRequestDto conductor) {
        return Conductor.builder().id(conductor.getId()).build();
    }
}
