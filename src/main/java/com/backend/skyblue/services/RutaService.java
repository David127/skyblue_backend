package com.backend.skyblue.services;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.CargoRequestDto;
import com.backend.skyblue.dto.request.RutaRequestDto;
import com.backend.skyblue.dto.response.CargoResponseDto;
import com.backend.skyblue.dto.response.RutaResponseDto;
import com.backend.skyblue.mapper.CargoMapper;
import com.backend.skyblue.mapper.RutaMapper;
import com.backend.skyblue.models.Cargo;
import com.backend.skyblue.models.Ruta;
import com.backend.skyblue.repository.CargoRepository;
import com.backend.skyblue.repository.RutaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RutaService {
	private final RutaRepository rutaRepository;
	private  final RutaBuilderService rutaBuilderService;
	public PageResponseDto listarRutaEnPaginas(Pageable pageable) {
		Page<Ruta> rutaFound = rutaRepository.findAll(pageable);
		return RutaMapper.buildRutaPageResponseDto(rutaFound);
	}

	public boolean existeRuta(RutaRequestDto request) {
		return rutaRepository.existsById(request.getId());
	}

	public RutaResponseDto insertarActualizar(RutaRequestDto request) {
		if(existeRuta(request))
			return actualizar(request);
		return create(request);
	}

	private RutaResponseDto actualizar(RutaRequestDto request) {
		if(request == null)
			throw new IllegalArgumentException("La ruta no puedo ser nulo");
		if(request.getId() == null)
			throw new IllegalArgumentException("El id no puede ser nulo");
		RutaResponseDto rutaResponse = CreateNewRuta(request);
		return  rutaResponse;
	}

	private RutaResponseDto CreateNewRuta(RutaRequestDto request) {
		var ruta = rutaBuilderService.buildNewRuta(request);
		save(ruta);
		return RutaMapper.buildResponseDto(ruta);
	}

	private RutaResponseDto create(RutaRequestDto request) {
		RutaResponseDto  rutaResponse = CreateNewRuta(request);
		return  rutaResponse;
	}
	@Transactional
	private Ruta save(Ruta ruta) {
		var rutaSaved = rutaRepository.saveAndFlush(ruta);
		return rutaSaved;
	}


}
