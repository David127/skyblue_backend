package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.EmpresaRequestDto;
import com.backend.skyblue.dto.response.EmpresaResponseDto;
import com.backend.skyblue.models.Empresa;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface EmpresaMapper {
	Integer PAGINATION_OFFSET = 1;

	static EmpresaResponseDto buildResponseDto(Empresa empresa) {
		return EmpresaResponseDto.builder()
				.id(empresa.getId())
				.nombre(empresa.getNombre())
				.direccion(empresa.getDireccion())
				.correo(empresa.getCorreo())
				.telefono(empresa.getTelefono())
				.ruc(empresa.getRuc())
				.logo(empresa.getLogo())
				.ubigeo(UbigeoMapper.builResponseDto(empresa.getUbigeo()))
				.ruta(RutaMapper.buildResponseDto(empresa.getRuta()))
				.build();
	}

	static PageResponseDto buildEmpresaPageResponseDto(Page<Empresa> empresaPage) {
		var empresas = EmpresaMapper.buildListResponseEntities(empresaPage.getContent());
		return PageResponseDto.builder()
				.data(empresas)
				.pagination(PaginationMapper.buildPaginationResponseFromPage(empresaPage))
				.build();


	}

	static List<EmpresaResponseDto> buildListResponseEntities(List<Empresa> empresas) {
		return empresas.stream()
				.map(emp -> EmpresaMapper.buildResponseDto(emp))
				.collect(Collectors.toList());
	}

	static Empresa buildEntidadFromDto(EmpresaRequestDto empresaRequestDto) {
		return Empresa.builder()
				.id(empresaRequestDto.getId())
				.ruc(empresaRequestDto.getRuc())
				.nombre(empresaRequestDto.getNombre())
				.direccion(empresaRequestDto.getDireccion())
				.telefono(empresaRequestDto.getTelefono())
				.correo(empresaRequestDto.getCorreo())
				.logo(empresaRequestDto.getLogo())
				.ubigeo(UbigeoMapper.buildRequestDto(empresaRequestDto.getUbigeo()))
				.ruta(RutaMapper.buildRequestDto(empresaRequestDto.getRuta()))
				.build();
	}
}
