package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.ConductorRequestDto;
import com.backend.skyblue.dto.response.ConductorResponseDto;
import com.backend.skyblue.models.Conductor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface ConductorMapper {

    Integer PAGINATION_OFFSET = 1;

    static PageResponseDto buildConductorPageResponseDto(
            Page<Conductor> conductorPage) {
        var conductores = ConductorMapper.buildListResponseEntities(conductorPage.getContent());

        return PageResponseDto.builder()
                .data(conductores)
                .pagination(PaginationMapper.buildPaginationResponseFromPage(conductorPage))
                .build();
    }

    static List<ConductorResponseDto> buildListResponseEntities(List<Conductor> conductores) {
        return conductores.stream()
                .map(cndtrs -> ConductorMapper.buildResponseDto(cndtrs))
                .collect(Collectors.toList());
    }

    public static ConductorResponseDto buildResponseDto(Conductor conductor) {


        return ConductorResponseDto.builder()
                .id(conductor.getId())
                .nombre(conductor.getNombre())
                .apellidoPaterno(conductor.getApellidoPaterno())
                .apellidoMaterno(conductor.getApellidoMaterno())
                .tipoDocumento(conductor.getTipoDocumento())
                .nroDocumento(conductor.getNroDocumento())
                .telefono(conductor.getTelefono())
                .correo(conductor.getCorreo())
                .direccion(conductor.getDireccion())
                .sexo(conductor.getSexo())
                .estadoCivil(conductor.getEstadoCivil())
                .fechaNacimiento(conductor.getFechaNacimiento())
                .observacion(conductor.getObservacion())
                .estado(conductor.getEstado())
                .nroLicenciaCorrelativo(conductor.getNroLicenciaCorrelativo())
                .claseCategoria(conductor.getClaseCategoria())
                .estadoLicencia(conductor.getEstadoLicencia())
                .fechaExpedicion(conductor.getFechaExpedicion())
                .fechaRevalidacion(conductor.getFechaRevalidacion())
                .restricciones(conductor.getRestricciones())
                .build();
    }

    static Conductor buildRequestDto(ConductorRequestDto conductor) {
        return Conductor.builder()
                .id(conductor.getId())
                .nombre(conductor.getNombre())
                .apellidoPaterno(conductor.getApellidoPaterno())
                .apellidoMaterno(conductor.getApellidoMaterno())
                .tipoDocumento(conductor.getTipoDocumento())
                .nroDocumento(conductor.getNroDocumento())
                .telefono(conductor.getTelefono())
                .correo(conductor.getCorreo())
                .direccion(conductor.getDireccion())
                .sexo(conductor.getSexo())
                .estadoCivil(conductor.getEstadoCivil())
                .fechaNacimiento(conductor.getFechaNacimiento())
                .observacion(conductor.getObservacion())
                .estado(conductor.getEstado())
                .nroLicenciaCorrelativo(conductor.getNroLicenciaCorrelativo())
                .claseCategoria(conductor.getClaseCategoria())
                .estadoLicencia(conductor.getEstadoLicencia())
                .fechaExpedicion(conductor.getFechaExpedicion())
                .fechaRevalidacion(conductor.getFechaRevalidacion())
                .restricciones(conductor.getRestricciones())
                .build();
    }

    static Conductor buildEntidadFromDto(ConductorRequestDto conductorRequestDto) {
        return Conductor.builder()
                .id(conductorRequestDto.getId())
                .nombre(conductorRequestDto.getNombre())
                .apellidoPaterno(conductorRequestDto.getApellidoPaterno())
                .apellidoMaterno(conductorRequestDto.getApellidoMaterno())
                .tipoDocumento(conductorRequestDto.getTipoDocumento())
                .nroDocumento(conductorRequestDto.getNroDocumento())
                .telefono(conductorRequestDto.getTelefono())
                .correo(conductorRequestDto.getCorreo())
                .direccion(conductorRequestDto.getDireccion())
                .sexo(conductorRequestDto.getSexo())
                .estadoCivil(conductorRequestDto.getEstadoCivil())
                .fechaNacimiento(conductorRequestDto.getFechaNacimiento())
                .observacion(conductorRequestDto.getObservacion())
                .estado(conductorRequestDto.getEstado())
                .nroLicenciaCorrelativo(conductorRequestDto.getNroLicenciaCorrelativo())
                .claseCategoria(conductorRequestDto.getClaseCategoria())
                .estadoLicencia(conductorRequestDto.getEstadoLicencia())
                .fechaExpedicion(conductorRequestDto.getFechaExpedicion())
                .fechaRevalidacion(conductorRequestDto.getFechaRevalidacion())
                .restricciones(conductorRequestDto.getRestricciones())
                .build();

    }
}
