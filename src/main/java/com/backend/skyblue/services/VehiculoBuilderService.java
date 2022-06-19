package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.VehiculoRequestDto;
import com.backend.skyblue.models.Vehiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehiculoBuilderService {

    public Vehiculo buildNewVehiculo(VehiculoRequestDto request) {
        return  Vehiculo.createBuilder()
                .vehiculoDto(request)
                .build();
    }
}
