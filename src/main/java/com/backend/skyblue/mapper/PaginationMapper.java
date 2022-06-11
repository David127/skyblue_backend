package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.common.PaginationResponseDTO;
import com.backend.skyblue.models.Trabajador;
import org.springframework.data.domain.Page;

import static com.backend.skyblue.mapper.TrabajadorMappers.PAGINATION_OFFSET;

public interface PaginationMapper {

    static PaginationResponseDTO buildPaginationResponseFromTrabajadorPage(
            Page<Trabajador> trabajadorPage){
        return PaginationResponseDTO.builder()
                .totalPages(trabajadorPage.getTotalPages())
                .totalElements(trabajadorPage.getTotalElements())
                .page(trabajadorPage.getNumber() + PAGINATION_OFFSET)
                .pageSize(trabajadorPage.getSize())
                .numberOfElements(trabajadorPage.getNumberOfElements())
                .isFirst(trabajadorPage.isFirst())
                .isLast(trabajadorPage.isLast())
                .build();
                
    }
    
}
