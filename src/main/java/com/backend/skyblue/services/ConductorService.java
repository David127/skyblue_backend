package com.backend.skyblue.services;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.ConductorRequestDto;
import com.backend.skyblue.dto.response.ConductorResponseDto;
import com.backend.skyblue.mapper.ConductorMapper;
import com.backend.skyblue.models.Conductor;
import com.backend.skyblue.repository.ConductorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ConductorService {
	private final ConductorRepository conductorRepository;

	private final ConductorBuilderService conductorBuilderService;

	public boolean existeConductor(ConductorRequestDto obj) {
		return conductorRepository.existsById(obj.getId());
	}

	public PageResponseDto listarConductorEnPaginas(Pageable pageable) {
		Page<Conductor> conductorFound = conductorRepository.findAll(pageable);
		return ConductorMapper.buildConductorPageResponseDto(conductorFound);
	}

	public ConductorResponseDto insertarActualizar(ConductorRequestDto request) {
		if(existeConductor(request))
			return  actualizar(request);
		return  create(request);
	}

	private ConductorResponseDto create(ConductorRequestDto request) {
		ConductorResponseDto conductorResponseD = createNewConductor(request);
		return conductorResponseD;
	}

	@Transactional
	private Conductor save(Conductor conductor) {
		var conductorSaved = conductorRepository.saveAndFlush(conductor);
		return conductorSaved;
	}

	private ConductorResponseDto actualizar(ConductorRequestDto request) {
		if(request == null)
			throw new IllegalArgumentException("El Conductor no puedo ser nulo");
		if(request.getId()== null)
			throw new IllegalArgumentException("El id no puede ser nulo");
		ConductorResponseDto conductorResponse = createNewConductor(request);
		return  conductorResponse;
	}

	private ConductorResponseDto createNewConductor(ConductorRequestDto request) {
		var conductor = conductorBuilderService.buildNewConductor(request);
		save(conductor);
		return ConductorMapper.buildResponseDto(conductor);
	}
}
