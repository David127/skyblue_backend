package com.backend.skyblue.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GericListTrabajador {
  public GericListTrabajador(){
      this.trabajador = new ArrayList<>();
  }
  private List<GericListTrabajador> trabajador;

}
