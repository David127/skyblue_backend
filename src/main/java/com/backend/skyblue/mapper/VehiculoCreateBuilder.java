package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.VehiculoRequestDto;
import com.backend.skyblue.models.Vehiculo;

public class VehiculoCreateBuilder {

    private Vehiculo vehiculo;
    private VehiculoRequestDto vehiculoRequestDto;

    public VehiculoCreateBuilder vehiculoDto(VehiculoRequestDto request){
        this.vehiculoRequestDto = request;
        vehiculo = VehiculoMapper.buildEntidadFromDto(request);
        return this;
    }

    public Vehiculo build(){
        return vehiculo;
    }
}
