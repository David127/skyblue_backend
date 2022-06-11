package com.backend.skyblue.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SueldoResponseDto implements Serializable {
    private Long id;
    private String turno;
    private Integer dias;
    private Integer mesess;
    private Double horasExtras;
    private Double Base;
    private Double dolares;
    private Double soles;
    private Double total;
}
