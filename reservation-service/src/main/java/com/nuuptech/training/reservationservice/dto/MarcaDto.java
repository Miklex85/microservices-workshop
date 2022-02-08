package com.nuuptech.training.reservationservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MarcaDto implements Serializable {

    private Long id;

    private String nombre;

    private boolean activa;
}
