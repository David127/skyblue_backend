package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.EmpresaRequestDto;
import com.backend.skyblue.models.Empresa;

public class EmpresaCreateBuilder {
	private Empresa empresa;
	private EmpresaRequestDto empresaRequestDto;

	public EmpresaCreateBuilder empresaDto(EmpresaRequestDto empresaRequestDto) {
		this.empresaRequestDto = empresaRequestDto;
		empresa = EmpresaMapper.buildEntidadFromDto(empresaRequestDto);
		return this;
	}

	public Empresa build() {
		return empresa;
	}
}
