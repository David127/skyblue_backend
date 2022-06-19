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
public class RutaResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    private Long id;
    private String codigoRuta;
    private String clase;
    private String lugarOrigen;
    private String lugarDestino;
    private Double distaciaIda;
    private Double distaciaVuelta;

}
