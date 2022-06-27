package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.RutaRequestDto;
import com.backend.skyblue.dto.response.RutaResponseDto;
import com.backend.skyblue.models.Ruta;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface RutaMapper {
    Integer PAGINATION_OFFSET = 1;
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
    static PageResponseDto buildRutaPageResponseDto(Page<Ruta> rutaPage) {
        var rutas = RutaMapper.buildListResponseEntities(rutaPage.getContent());
        return PageResponseDto.builder()
                .data(rutas)
                .pagination(PaginationMapper.buildPaginationResponseFromPage(rutaPage))
                .build();
    }
    static List<RutaResponseDto> buildListResponseEntities(List<Ruta> rutas) {
        return rutas.stream()
                .map(rts -> RutaMapper.buildResponseDto(rts))
                .collect(Collectors.toList());
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
