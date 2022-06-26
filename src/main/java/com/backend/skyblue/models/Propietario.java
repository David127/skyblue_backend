package com.backend.skyblue.models;

import com.backend.skyblue.mapper.ConductorCreateBuilder;
import com.backend.skyblue.mapper.PropietarioCreateBuilder;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "propietario")
public class Propietario implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private String nroDocumento;
    private String telefono;
    private String correo;
    private String direccion;
    private String sexo;
    private String estadoCivil;
    private String fechaNacimiento;
    private String fechaIngreso;
    private String fechaSalida;
    private String observacion;
    private String estado;
    @CreatedDate
    private Timestamp createAt;
    @CreatedDate
    private Timestamp updateAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubigeo_id")
    private Ubigeo ubigeo;

    public static PropietarioCreateBuilder createBuilder() {
        return new PropietarioCreateBuilder();
    }

}
