package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.RutaRequestDto;
import com.backend.skyblue.dto.request.VehiculoRequestDto;
import com.backend.skyblue.dto.response.RutaResponseDto;
import com.backend.skyblue.models.Ruta;
import com.backend.skyblue.models.Vehiculo;

public interface RutaMapper {

    static RutaResponseDto buildResponseDto(Ruta ruta){
        return RutaResponseDto.builder()
                .id(ruta.getId())
                .codigoRuta(ruta.getCodigoRuta())
                .clase(ruta.getClase())
                .lugarOrigen(ruta.getLugarOrigen())
                .lugarDestino(ruta.getLugarDestino())
                .distaciaIda(ruta.getDistaciaIda())
                .distaciaVuelta(ruta.getDistaciaVuelta())
                .build();
    }

    public static Ruta buildRequestDto(RutaRequestDto ruta) {

        return Ruta.builder()
                .id(ruta.getId())
                .build();
    }


    static Ruta buildEntidadFromDto(RutaRequestDto rutaRequestDto){
        return Ruta.builder()
                .id(rutaRequestDto.getId())
                .codigoRuta(rutaRequestDto.getCodigoRuta())
                .clase(rutaRequestDto.getClase())
                .lugarOrigen(rutaRequestDto.getLugarOrigen())
                .lugarDestino(rutaRequestDto.getLugarDestino())
                .distaciaIda(rutaRequestDto.getDistaciaIda())
                .distaciaVuelta(rutaRequestDto.getDistaciaVuelta())
                .build();
    }
}
