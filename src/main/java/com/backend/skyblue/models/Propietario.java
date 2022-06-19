package com.backend.skyblue.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name = "propietario")
@Entity
@Data
public class Propietario implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
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

}
