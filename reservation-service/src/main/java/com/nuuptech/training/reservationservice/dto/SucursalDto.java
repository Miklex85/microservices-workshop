package com.nuuptech.training.reservationservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SucursalDto implements Serializable {

    private Long id;

    private String nombre;

    private String direccion;

    private  String horario;
}
