package com.backend.skyblue.models;

import com.backend.skyblue.mapper.ViajeCreateBuilder;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "viajes")
public class Viaje implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String horaRegistro;
    private String horaSalida;
    private String horaLlegada;
    private Double nroVueltas;
    private String fecha;
    private String terminal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

	public static ViajeCreateBuilder createBuilder() {
        return new ViajeCreateBuilder();
	}
}
