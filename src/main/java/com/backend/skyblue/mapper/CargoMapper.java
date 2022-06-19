package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.CargoRequestDto;
import com.backend.skyblue.dto.response.CargoResponseDto;
import com.backend.skyblue.models.Cargo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface CargoMapper {
    Integer PAGINATION_OFFSET = 1;
    static CargoResponseDto buildResponseDto(Cargo cargo) {

        return CargoResponseDto.builder()
                .id(cargo.getId())
                .nombre(cargo.getNombre())
                .descripcion(cargo.getDescripcion())
                .build();
    }

    static Cargo buildRequestDto(CargoRequestDto cargo) {
        return Cargo.builder()
                .id(cargo.getId())
                .nombre(cargo.getNombre())
                .descripcion(cargo.getDescripcion())
                .responsable(cargo.getResponsable())
                .build();
    }


    static PageResponseDto buildCargoPageResponseDto(Page<Cargo> cargoPage) {
        var cargos = CargoMapper.buildListResponseEntities(cargoPage.getContent());
        return PageResponseDto.builder()
                .data(cargos)
                .pagination(PaginationMapper.buildPaginationResponseFromPage(cargoPage))
                .build();
    }

    static List<CargoResponseDto> buildListResponseEntities(List<Cargo> cargos) {
        return cargos.stream()
                .map(crs -> CargoMapper.buildResponseDto(crs))
                .collect(Collectors.toList());
    }

    static Cargo buildEntidadFromDto(CargoRequestDto request) {
        return  Cargo.builder()
                .id(request.getId())
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .responsable(request.getResponsable())
                .build();

    }
}
