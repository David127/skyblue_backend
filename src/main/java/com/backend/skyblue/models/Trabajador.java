package com.backend.skyblue.models;

import com.backend.skyblue.mapper.TrabajadorCreateBuilder;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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


    //@OneToMany(targetEntity = Sueldo.class, cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
   // @JoinColumn(name = "fk_trabajador",referencedColumnName = "id")
    @JsonBackReference
    private Set<Sueldo> sueldo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubigeo_id")
    private Ubigeo ubigeo;
    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    public  void addSueldos(List<Sueldo> sueldo){
        if(CollectionUtils.isEmpty(this.sueldo)){
            this.sueldo = new HashSet<>();
        }
        sueldo.forEach(this::addSueldo);
    }

    private void addSueldo(Sueldo s) {
        if(CollectionUtils.isEmpty(sueldo)){
            sueldo = new HashSet<>();
        }
        sueldo.add(s);
    }

    public static TrabajadorCreateBuilder createBuilder(){
        return new TrabajadorCreateBuilder();
    }

}
