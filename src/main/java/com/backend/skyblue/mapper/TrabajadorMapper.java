package com.backend.skyblue.mapper;
import com.backend.skyblue.dto.request.TrabajadorRequestDto;
import com.backend.skyblue.dto.response.PageResponseDto;
import com.backend.skyblue.dto.response.TrabajadorResponseDto;
import com.backend.skyblue.models.Trabajador;
import org.springframework.data.domain.Page;

import java.util.List;

import java.util.stream.Collectors;
public interface TrabajadorMapper {
    Integer PAGINATION_OFFSET = 1;

    //listado
    static List<TrabajadorResponseDto> buildListResponseEntities(
            List<Trabajador> trabajador){
        return trabajador.stream()
                .map(tb-> TrabajadorMapper.buildResponseDtoFrontEntity(tb))
                .collect(Collectors.toList());
    }
    static TrabajadorResponseDto buildResponseDtoFrontEntity(Trabajador trabajador){
        return  buildResponseDTO(trabajador);
    }
    static TrabajadorResponseDto buildResponseDTO(Trabajador trabajador) {
          var trabajadorDto =  TrabajadorResponseDto.builder()
                  .id(trabajador.getId())
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
                  .cargo(CargoMapper.buildResponseDto(trabajador.getCargo()))
                  .ubigeo(UbigeoMapper.builResponseDto(trabajador.getUbigeo()))
                .build();

        trabajadorDto.setSueldos(
                SueldoMapper.buildSuedoResponseSet(trabajador.getSueldos())
        );
          return trabajadorDto;
    }

    static PageResponseDto buildTrabajadorPageResponseDto(
            Page<Trabajador> trabajadorPage){
        var trabajadores = TrabajadorMapper.buildListResponseEntities(trabajadorPage.getContent());

        return PageResponseDto.builder().
                data(trabajadores)
                .pagination(PaginationMapper.buildPaginationResponseFromPage(trabajadorPage))
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
                .cargo(CargoMapper.buildRequestDto(trabajadorRequestDto.getCargo()))
                .ubigeo(UbigeoMapper.buildRequestDto(trabajadorRequestDto.getUbigeo()))
                .build();

    }
}

