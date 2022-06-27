package com.backend.skyblue.models;

import com.backend.skyblue.mapper.CargoCreateBuilder;
import com.backend.skyblue.mapper.RutaCreateBuilder;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Table(name = "ruta")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ruta implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoRuta;
    private String clase;
    private String lugarOrigen;
    private String lugarDestino;
    private Double distaciaIda;
    private Double distaciaVuelta;

    public static RutaCreateBuilder createBuilder() {

        return new RutaCreateBuilder();
    }
}
