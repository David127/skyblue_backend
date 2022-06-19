package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.common.PaginationResponseDTO;
import org.springframework.data.domain.Page;

import static com.backend.skyblue.mapper.VehiculoMapper.PAGINATION_OFFSET;


public interface PaginationMapper {

    static PaginationResponseDTO buildPaginationResponseFromPage(
            Page<?> page) {
        return PaginationResponseDTO.builder()
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .page(page.getNumber() + PAGINATION_OFFSET)
                .pageSize(page.getSize())
                .numberOfElements(page.getNumberOfElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();

    }

}
