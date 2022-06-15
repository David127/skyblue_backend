package com.backend.skyblue.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown =true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationResponseDTO implements Serializable {
    @Serial private static  final  long serialVersionUID = -1L;

    Integer totalPages;
    Long totalElements;
    Integer page;
    Integer pageSize;
    Integer numberOfElements;
    Boolean isLast;
    Boolean isFirst;

}
