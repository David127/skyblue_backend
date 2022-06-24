package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.ConductorRequestDto;
import com.backend.skyblue.dto.request.PropietarioRequestDto;
import com.backend.skyblue.dto.response.ConductorResponseDto;
import com.backend.skyblue.dto.response.PropietarioResponseDto;
import com.backend.skyblue.models.Conductor;
import com.backend.skyblue.models.Propietario;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface PropietarioMapper {
	Integer PAGINATION_OFFSET = 1;

	static PageResponseDto buildPropietarioPageResponseDto(
			Page<Propietario> propietarioPage) {
		var propietarios = PropietarioMapper.buildListResponseEntities(propietarioPage.getContent());

		return PageResponseDto.builder()
				.data(propietarios)
				.pagination(PaginationMapper.buildPaginationResponseFromPage(propietarioPage))
				.build();
	}

	static List<PropietarioResponseDto> buildListResponseEntities(List<Propietario> propietarios) {
		return propietarios.stream()
				.map(prptrs -> PropietarioMapper.buildResponseDto(prptrs))
				.collect(Collectors.toList());
	}

	public static PropietarioResponseDto buildResponseDto(Propietario propietario) {

		return PropietarioResponseDto.builder()
				.id(propietario.getId())
				.nombre(propietario.getNombre())
				.apellidoPaterno(propietario.getApellidoPaterno())
				.apellidoMaterno(propietario.getApellidoMaterno())
				.tipoDocumento(propietario.getTipoDocumento())
				.nroDocumento(propietario.getNroDocumento())
				.telefono(propietario.getTelefono())
				.correo(propietario.getCorreo())
				.direccion(propietario.getDireccion())
				.sexo(propietario.getSexo())
				.estadoCivil(propietario.getEstadoCivil())
				.fechaNacimiento(propietario.getFechaNacimiento())
				.fechaIngreso(propietario.getFechaIngreso())
				.fechaSalida(propietario.getFechaSalida())
				.observacion(propietario.getObservacion())
				.estado(propietario.getEstado())
				.ubigeo(UbigeoMapper.builResponseDto(propietario.getUbigeo()))
				.build();
	}

	public static Propietario buildRequestDto(PropietarioRequestDto propietario) {
		return Propietario.builder().id(propietario.getId()).build();
	}

	static Propietario buildEntidadFromDto(PropietarioRequestDto propietarioRequestDto) {
		return Propietario.builder()
				.id(propietarioRequestDto.getId())
				.nombre(propietarioRequestDto.getNombre())
				.apellidoPaterno(propietarioRequestDto.getApellidoPaterno())
				.apellidoMaterno(propietarioRequestDto.getApellidoMaterno())
				.tipoDocumento(propietarioRequestDto.getTipoDocumento())
				.nroDocumento(propietarioRequestDto.getNroDocumento())
				.telefono(propietarioRequestDto.getTelefono())
				.correo(propietarioRequestDto.getCorreo())
				.direccion(propietarioRequestDto.getDireccion())
				.sexo(propietarioRequestDto.getSexo())
				.estadoCivil(propietarioRequestDto.getEstadoCivil())
				.fechaNacimiento(propietarioRequestDto.getFechaNacimiento())
				.fechaIngreso(propietarioRequestDto.getFechaIngreso())
				.fechaSalida(propietarioRequestDto.getFechaSalida())
				.observacion(propietarioRequestDto.getObservacion())
				.estado(propietarioRequestDto.getEstado())
				.ubigeo(UbigeoMapper.buildRequestDto(propietarioRequestDto.getUbigeo()))
				.build();

	}
}