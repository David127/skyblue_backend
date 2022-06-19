package com.backend.skyblue.models;

import com.backend.skyblue.mapper.CargoCreateBuilder;
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
@Table(name = "cargo")
public class Cargo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String responsable;

	public static CargoCreateBuilder createBuilder() {
		return new CargoCreateBuilder();
	}
}
