package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.VehiculoRequestDto;
import com.backend.skyblue.dto.response.VehiculoResponseDto;
import com.backend.skyblue.models.Vehiculo;

public interface VehiculoMapper {
    Integer PAGINATION_OFFSET = 1;
    public static VehiculoResponseDto buildResponseDto(Vehiculo vehiculo) {

        return VehiculoResponseDto.builder()
                .id(vehiculo.getId())
                .padron(vehiculo.getPadron())
                .placa(vehiculo.getPlaca())
                .build();
    }

    public static Vehiculo buildRequestDto(VehiculoRequestDto vehiculo) {

        return Vehiculo.builder()
                .id(vehiculo.getId())
                .build();
    }
}
