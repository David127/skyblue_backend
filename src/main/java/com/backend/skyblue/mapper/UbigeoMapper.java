package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.UbigeoRequestDto;
import com.backend.skyblue.dto.response.UbigeoResponseDto;
import com.backend.skyblue.models.Ubigeo;

public interface UbigeoMapper {
    static UbigeoResponseDto builResponseDto(Ubigeo ubigeo) {

      return  UbigeoResponseDto.builder()
              .id(ubigeo.getId())
              .departamento(ubigeo.getDepartamento())
              .provincia(ubigeo.getProvincia())
              .distrito(ubigeo.getDistrito())
              .build();
    }


    static Ubigeo buildRequestDto(UbigeoRequestDto ubigeo) {

        return Ubigeo.builder()
                .id(ubigeo.getId())
                .build();
    }
}
