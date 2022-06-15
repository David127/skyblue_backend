package com.backend.skyblue.dto.response;

import com.backend.skyblue.dto.common.PaginationResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrabajadorPageResponseDTO implements Serializable {
    @Serial private static  final  long serialVersionUID = -1313;

    private List<TrabajadorResponseDTO> trabajadores;

    private PaginationResponseDTO pagination;

}
