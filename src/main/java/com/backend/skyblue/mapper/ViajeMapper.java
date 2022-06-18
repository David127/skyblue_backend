package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.VehiculoRequestDto;
import com.backend.skyblue.dto.request.ViajeRequestDto;
import com.backend.skyblue.dto.response.ViajeResponseDto;
import com.backend.skyblue.models.Vehiculo;
import com.backend.skyblue.models.Viaje;

public interface ViajeMapper {

    static ViajeResponseDto buildResponseDto(Viaje viaje){
        return  ViajeResponseDto.builder()
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

    static Viaje buildEntidadFromDto(ViajeRequestDto viajeRequestDto){
            return Viaje.builder()
                    .id(viajeRequestDto.getId())
                    .horaRegistro(viajeRequestDto.getHoraRegistro())
                    .horaSalida(viajeRequestDto.getHoraSalida())
                    .horaLlegada(viajeRequestDto.getHoraLlegada())
                    .conductor(ConductorMapper.buildRequestDto(viajeRequestDto.getConductor()))
                    .vehiculo(VehiculoMapper.buildRequestDto(viajeRequestDto.getVehiculo()))
                    .build();

    }


}
