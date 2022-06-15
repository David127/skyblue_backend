package com.backend.skyblue.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sueldo")
public class Sueldo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String turno;
    private String  meses;
    private String anio;
    private Double base;
}
