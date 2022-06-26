package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.RutaRequestDto;
import com.backend.skyblue.models.Cargo;
import com.backend.skyblue.models.Ruta;

public class RutaCreateBuilder {
	private Ruta ruta;
	private RutaRequestDto rutaRequest;

	public RutaCreateBuilder rutaDto(RutaRequestDto request){
		this.rutaRequest = request;
		ruta = RutaMapper.buildEntidadFromDto(request);
		return this;
	}
	public Ruta build(){
		return ruta;
	}
}
