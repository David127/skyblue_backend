package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.PropietarioRequestDto;
import com.backend.skyblue.models.Propietario;

public class PropietarioCreateBuilder {
	private Propietario propietario;
	private PropietarioRequestDto propietarioRequestDto;

	public PropietarioCreateBuilder propietarioDto(PropietarioRequestDto propietarioRequestDto) {
		this.propietarioRequestDto = propietarioRequestDto;
		propietario = PropietarioMapper.buildEntidadFromDto(propietarioRequestDto);
		return this;
	}

	public Propietario build() {
		return propietario;
	}
}
