package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.EmpresaRequestDto;
import com.backend.skyblue.models.Empresa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpresaBuilderService {
	public Empresa buildNewEmpresa(EmpresaRequestDto empresaRequestDto) {

		return Empresa.createBuilder()
				.empresaDto(empresaRequestDto)
				.build();

	}
}
