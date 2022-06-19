package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.ViajeRequestDto;
import com.backend.skyblue.models.Viaje;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViajeBuilderService {

	public Viaje buildNewViaje(ViajeRequestDto request) {
		return  Viaje.createBuilder()
				.viajeDto(request)
				.build();
	}
}
