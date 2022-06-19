package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.ConductorRequestDto;
import com.backend.skyblue.dto.request.SueldoRequestDto;
import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.models.Conductor;
import com.backend.skyblue.models.Trabajador;

import java.util.Set;

public class ConductorCreateBuilder {
	private Conductor conductor;
	private ConductorRequestDto conductorRequestDto;

	public ConductorCreateBuilder conductorDto(ConductorRequestDto conductorRequestDto) {
		this.conductorRequestDto = conductorRequestDto;
		conductor = ConductorMapper.buildEntidadFromDto(conductorRequestDto);
		return this;
	}

	public Conductor build() {
		return conductor;
	}
}
