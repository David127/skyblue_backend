package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.response.TrabajadorPageResponseDTO;
import com.backend.skyblue.models.Trabajador;
import com.backend.skyblue.dto.response.TrabajadorResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface TrabajadorMappers {

    Integer PAGINATION_OFFSET = 1;
    static List<TrabajadorResponseDTO> buildListResponseEntities(
            List<Trabajador> trabajador){
        return trabajador.stream()
                .map(tb-> TrabajadorMappers.buildResponseDtoFrontEntity(tb))
                .collect(Collectors.toList());

    }

    static TrabajadorResponseDTO buildResponseDtoFrontEntity(Trabajador trabajador){
        return buildResponseDTO(trabajador);
    }



    static TrabajadorResponseDTO buildResponseDTO(Trabajador trabajador){
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
                .fechaIngreso(trabajador.getFechaIngreso())
                .fechaSalida(trabajador.getFechaSalida())
                .observacion(trabajador.getObservacion())
                .estado(trabajador.getEstado())
                .build();

        trabajadorDto.setSueldo(
                SueldoMapper.builSuedoResponseSet(trabajador.getSueldo())
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


}

