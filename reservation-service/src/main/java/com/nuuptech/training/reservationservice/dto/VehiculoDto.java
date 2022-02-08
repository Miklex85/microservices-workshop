package com.nuuptech.training.reservationservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class VehiculoDto implements Serializable {

    private Long id;

    private String modelo;

    private String anio;

    private String kilometraje;

    private MarcaDto marca;

    private SucursalDto sucursal;

    private boolean disponible;

    private boolean activo;
}
