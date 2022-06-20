package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.ConductorRequestDto;
import com.backend.skyblue.models.Conductor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConductorBuilderService {
	public Conductor buildNewConductor(ConductorRequestDto conductorRequestDto) {

		return Conductor.createBuilder()
				.conductorDto(conductorRequestDto)
				.build();

	}
}
