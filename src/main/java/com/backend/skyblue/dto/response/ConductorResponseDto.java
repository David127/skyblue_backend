package com.backend.skyblue.dto.response;

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
public class ConductorResponseDto implements Serializable {
    @Serial
    private static  final long serialVersionUID  = 1L;
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
}
