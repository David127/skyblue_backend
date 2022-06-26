package com.backend.skyblue.services;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.EmpresaRequestDto;
import com.backend.skyblue.dto.response.EmpresaResponseDto;
import com.backend.skyblue.mapper.EmpresaMapper;
import com.backend.skyblue.models.Empresa;
import com.backend.skyblue.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class EmpresaService {
	private final EmpresaRepository empresaRepository;

	private final EmpresaBuilderService empresaBuilderService;

	public boolean existeEmpresa(EmpresaRequestDto obj) {
		return empresaRepository.existsById(obj.getId());
	}

	public PageResponseDto listarEmpresaEnPaginas(Pageable pageable) {
		Page<Empresa> empresaFound = empresaRepository.findAll(pageable);
		return EmpresaMapper.buildEmpresaPageResponseDto(empresaFound);
	}

	public EmpresaResponseDto insertarActualizar(EmpresaRequestDto request) {
		if(existeEmpresa(request))
			return  actualizar(request);
		return  create(request);
	}

	private EmpresaResponseDto create(EmpresaRequestDto request) {
		EmpresaResponseDto empresaResponseD = createNewEmpresa(request);
		return empresaResponseD;
	}

	@Transactional
	private Empresa save(Empresa empresa) {
		var empresaSaved = empresaRepository.saveAndFlush(empresa);
		return empresaSaved;
	}

	private EmpresaResponseDto actualizar(EmpresaRequestDto request) {
		if(request == null)
			throw new IllegalArgumentException("El Empresa no puedo ser nulo");
		if(request.getId()== null)
			throw new IllegalArgumentException("El id no puede ser nulo");
		EmpresaResponseDto empresaResponse = createNewEmpresa(request);
		return  empresaResponse;
	}

	private EmpresaResponseDto createNewEmpresa(EmpresaRequestDto request) {
		var empresa = empresaBuilderService.buildNewEmpresa(request);
		save(empresa);
		return EmpresaMapper.buildResponseDto(empresa);
	}

}
