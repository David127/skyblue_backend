package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.RutaRequestDto;
import com.backend.skyblue.models.Ruta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RutaBuilderService {
	public Ruta buildNewRuta(RutaRequestDto request) {
		return Ruta.createBuilder()
				.rutaDto(request)
				.build();
	}
}
