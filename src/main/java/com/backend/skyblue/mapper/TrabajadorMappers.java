package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.SueldoRequestDto;
import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.dto.response.TrabajadorPageResponseDTO;
import com.backend.skyblue.dto.response.TrabajadorResponseDTO;
import com.backend.skyblue.models.Trabajador;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface TrabajadorMappers {

    Integer PAGINATION_OFFSET = 1;

    //listado
    static List<TrabajadorResponseDTO> buildListResponseEntities(
            List<Trabajador> trabajador){
        return trabajador.stream()
                .map(tb-> TrabajadorMappers.buildResponseDtoFrontEntity(tb))
                .collect(Collectors.toList());

    }

    static TrabajadorResponseDTO buildResponseDtoFrontEntity(Trabajador trabajador){
        return  buildResponseDTO(trabajador);
    }
    static TrabajadorResponseDTO buildResponseDTO(Trabajador trabajador) {
          var trabajadorDto =  TrabajadorResponseDTO.builder()
                .nombre(trabajador.getNombre())
                .apellidoMaterno(trabajador.getApellidoMaterno())
                .tipoDocumento(trabajador.getTipoDocumento())
                .nroDocumento(trabajador.getNroDocumento())
                .telefono(trabajador.getTelefono())
                .correo(trabajador.getCorreo())
                .direccion(trabajador.getDireccion())
                .sexo(trabajador.getSexo())
                .estadoCivil(trabajador.getEstadoCivil())
                .fechaNacimiento(trabajador.getFechaNacimiento())
                .observacion(trabajador.getObservacion())

                .build();

        trabajadorDto.setSueldo(
                SueldoMapper.buildSuedoResponseSet(trabajador.getSueldos())
        );
          return trabajadorDto;
    }

    static TrabajadorPageResponseDTO buildTrabajadorPageResponseDto(
            Page<Trabajador> trabajadorPage){
        var trabajadores = TrabajadorMappers.buildListResponseEntities(trabajadorPage.getContent());

        return TrabajadorPageResponseDTO.builder().
                trabajadores(trabajadores)
                .pagination(PaginationMapper.buildPaginationResponseFromTrabajadorPage(trabajadorPage))
                .build();
    }


    static Trabajador buildEntidadFromDto(TrabajadorRequestDto trabajadorRequestDto) {
        return Trabajador.builder()
                .id(trabajadorRequestDto.getId())
                .nombre(trabajadorRequestDto.getNombre())
                .apellidoPaterno(trabajadorRequestDto.getApellidoPaterno())
                .apellidoMaterno(trabajadorRequestDto.getApellidoMaterno())
                .tipoDocumento(trabajadorRequestDto.getTipoDocumento())
                .nroDocumento(trabajadorRequestDto.getNroDocumento())
                .telefono(trabajadorRequestDto.getTelefono())
                .correo(trabajadorRequestDto.getCorreo())
                .direccion(trabajadorRequestDto.getDireccion())
                .sexo(trabajadorRequestDto.getSexo())
                .estadoCivil(trabajadorRequestDto.getEstadoCivil())
                .fechaNacimiento(trabajadorRequestDto.getFechaNacimiento())
                .observacion(trabajadorRequestDto.getObservacion())
                .estado(trabajadorRequestDto.getEstado())
                .build();

    }
}

