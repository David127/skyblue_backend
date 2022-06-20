package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.PropietarioRequestDto;
import com.backend.skyblue.models.Propietario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropietarioBuilderService {
	public Propietario buildNewPropietario(PropietarioRequestDto propietarioRequestDto) {

		return Propietario.createBuilder()
				.propietarioDto(propietarioRequestDto)
				.build();

	}
}
