package com.backend.skyblue.services;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.mapper.EmpresaMapper;
import com.backend.skyblue.models.Empresa;
import com.backend.skyblue.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpresaService {
	private  final EmpresaRepository empresaRepository;

	public PageResponseDto listarEmpresaEnPaginas(Pageable pageable) {
		Page<Empresa> empresaFound = empresaRepository.findAll(pageable);
		return EmpresaMapper.buildEmpresaPageResponseDto(empresaFound);
	}

}
