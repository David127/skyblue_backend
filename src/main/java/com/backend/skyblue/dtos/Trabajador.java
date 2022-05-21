package com.backend.skyblue.dtos;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "trabajador")
public class Trabajador implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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

    @OneToMany(targetEntity = Sueldo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_trabajador",referencedColumnName = "id")
    private List<Sueldo> sueldo;

    @OneToOne
    @JoinColumn(name = "ubigeo_id")
    private Ubigeo ubigeo;
    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

}
