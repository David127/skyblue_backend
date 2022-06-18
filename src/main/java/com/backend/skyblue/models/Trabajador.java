package com.backend.skyblue.models;
import com.backend.skyblue.mapper.TrabajadorCreateBuilder;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.util.CollectionUtils;
import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serial;
import java.io.Serializable;
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
    private String observacion;
    private String estado;

    @Valid
    @OneToMany(targetEntity = Sueldo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "trabajador_id",referencedColumnName = "id")
    @JsonBackReference
    private Set<Sueldo> sueldos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubigeo_id")
    private Ubigeo ubigeo;
    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    public  void addSueldos(List<Sueldo> sueldo){
        if(CollectionUtils.isEmpty(this.sueldos)){
            this.sueldos = new HashSet<>();
        }
        sueldo.forEach(this::addSueldo);
    }

    private void addSueldo(Sueldo s) {
        if(CollectionUtils.isEmpty(sueldos)){
            sueldos = new HashSet<>();
        }
        sueldos.add(s);
    }

    public static TrabajadorCreateBuilder createBuilder(){
        return new TrabajadorCreateBuilder();
    }


}
