package com.backend.skyblue.dto.response;

import lombok.*;

import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoResponseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    private Long id ;
    private String placa;
    private String padron;
}
