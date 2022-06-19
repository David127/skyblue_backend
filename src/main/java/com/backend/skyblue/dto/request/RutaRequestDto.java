package com.backend.skyblue.dto.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RutaRequestDto implements Serializable {

    private static final long serialVersionUID = 2L;

    private Long id;
    private String codigoRuta;
    private String clase;
    private String lugarOrigen;
    private String lugarDestino;
    private Double distaciaIda;
    private Double distaciaVuelta;

}
