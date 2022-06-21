package com.backend.skyblue.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RutaRequestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    private Long id;
    private String codigoRuta;
    @NotNull
    private String clase;
    @NotNull
    private String lugarOrigen;
    @NotNull
    private String lugarDestino;
    private Double distaciaIda;
    private Double distaciaVuelta;

}
