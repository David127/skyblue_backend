package com.backend.skyblue.dto.request;

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
public class SueldoRequestDto implements Serializable {

    @Serial
    private static  final long serialVersionUID  = 1L;
    private Long id;
    private String turno;
    private Integer dias;
    private String meses;
    private String anio;
    private Double base;
    private Double total;
}
