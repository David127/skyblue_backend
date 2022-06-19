package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.ViajeRequestDto;
import com.backend.skyblue.models.Viaje;

public class ViajeCreateBuilder {
	private Viaje viaje;
	private ViajeRequestDto viajeRequestDto;

	public ViajeCreateBuilder viajeDto(ViajeRequestDto request) {
		this.viajeRequestDto = request;
		viaje = ViajeMapper.buildEntidadFromDto(request);
		return this;
	}
	public Viaje build(){
		return viaje;
	}
	
}
