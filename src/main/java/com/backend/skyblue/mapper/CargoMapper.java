package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.CargoRequestDto;
import com.backend.skyblue.dto.response.CargoResponseDto;
import com.backend.skyblue.models.Cargo;

public interface CargoMapper {

    static CargoResponseDto buildResponseDto(Cargo cargo) {

        return CargoResponseDto.builder()
                .id(cargo.getId())
                .nombre(cargo.getNombre())
                .descripcion(cargo.getDescripcion())
                .build();
    }

    static Cargo buildRequestDto(CargoRequestDto cargo) {
        return Cargo.builder()
                .id(cargo.getId())
                .build();
    }
}
