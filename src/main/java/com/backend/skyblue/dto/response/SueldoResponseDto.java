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
    private String anio;
    private String meses;
    private Double Base;
}
