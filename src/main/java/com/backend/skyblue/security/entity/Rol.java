package com.backend.skyblue.security.entity;

import com.backend.skyblue.security.enums.RolNombre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
public class Rol {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    public Rol() {

    }
    public Rol(@NotNull RolNombre roleUser) {
        this.rolNombre = roleUser;
    }
}
