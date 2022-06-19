package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.ViajeRequestDto;
import com.backend.skyblue.dto.response.ViajeResponseDto;
import com.backend.skyblue.models.Viaje;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface ViajeMapper {
    static ViajeResponseDto buildResponseDto(Viaje viaje) {
        return ViajeResponseDto.builder()
                .id(viaje.getId())
                .fecha(viaje.getFecha())
                .horaRegistro(viaje.getHoraRegistro())
                .horaSalida(viaje.getHoraSalida())
                .horaLlegada(viaje.getHoraLlegada())
                .nroVueltas(viaje.getNroVueltas())
                .terminal(viaje.getTerminal())
                .conductor(ConductorMapper.buildResponseDto(viaje.getConductor()))
                .vehiculo(VehiculoMapper.buildResponseDto(viaje.getVehiculo()))
                .build();
    }

    static Viaje buildEntidadFromDto(ViajeRequestDto viajeRequestDto) {
        return Viaje.builder()
                .id(viajeRequestDto.getId())
                .horaRegistro(viajeRequestDto.getHoraRegistro())
                .horaSalida(viajeRequestDto.getHoraSalida())
                .horaLlegada(viajeRequestDto.getHoraLlegada())
                .fecha(viajeRequestDto.getFecha())
                .terminal(viajeRequestDto.getTerminal())
                .nroVueltas(viajeRequestDto.getNroVueltas())
                .conductor(ConductorMapper.buildRequestDto(viajeRequestDto.getConductor()))
                .vehiculo(VehiculoMapper.buildRequestDto(viajeRequestDto.getVehiculo()))
                .build();

    }

    static PageResponseDto buildViajePageResponseDto(
            Page<Viaje> viajePage) {
        var viajes = ViajeMapper.buildListResponseEntities(viajePage.getContent());

        return PageResponseDto.builder()
                .data(viajes)
                .pagination(PaginationMapper.buildPaginationResponseFromPage(viajePage))
                .build();
    }

    static List<ViajeResponseDto> buildListResponseEntities(List<Viaje> viajes) {
        return viajes.stream()
                .map(vjs -> ViajeMapper.buildResponseDto(vjs))
                .collect(Collectors.toList());
    }

}
