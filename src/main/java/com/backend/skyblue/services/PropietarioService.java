package com.backend.skyblue.services;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.PropietarioRequestDto;
import com.backend.skyblue.dto.response.PropietarioResponseDto;
import com.backend.skyblue.mapper.PropietarioMapper;
import com.backend.skyblue.models.Propietario;
import com.backend.skyblue.repository.PropietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PropietarioService {
	private final PropietarioRepository propietarioRepository;

	private final PropietarioBuilderService propietarioBuilderService;

	public boolean existePropietario(PropietarioRequestDto obj) {
		return propietarioRepository.existsById(obj.getId());
	}

	public PageResponseDto listarPropietarioEnPaginas(Pageable pageable) {
		Page<Propietario> propietarioFound = propietarioRepository.findAll(pageable);
		return PropietarioMapper.buildPropietarioPageResponseDto(propietarioFound);
	}

	public PropietarioResponseDto insertarActualizar(PropietarioRequestDto request) {
		if(existePropietario(request))
			return  actualizar(request);
		return  create(request);
	}

	private PropietarioResponseDto create(PropietarioRequestDto request) {
		PropietarioResponseDto propietarioResponseD = createNewPropietario(request);
		return propietarioResponseD;
	}

	@Transactional
	private Propietario save(Propietario propietario) {
		var propietarioSaved = propietarioRepository.saveAndFlush(propietario);
		return propietarioSaved;
	}

	private PropietarioResponseDto actualizar(PropietarioRequestDto request) {
		if(request == null)
			throw new IllegalArgumentException("El Propietario no puedo ser nulo");
		if(request.getId()== null)
			throw new IllegalArgumentException("El id no puede ser nulo");
		PropietarioResponseDto propietarioResponse = createNewPropietario(request);
		return  propietarioResponse;
	}

	private PropietarioResponseDto createNewPropietario(PropietarioRequestDto request) {
		var propietario = propietarioBuilderService.buildNewPropietario(request);
		save(propietario);
		return PropietarioMapper.buildResponseDto(propietario);
	}
}

