package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.CargoRequestDto;
import com.backend.skyblue.models.Cargo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CargoBuilderService {
	public Cargo buildNewCargo(CargoRequestDto request) {
		return Cargo.createBuilder()
				.cargoDto(request)
				.build();
	}
}
