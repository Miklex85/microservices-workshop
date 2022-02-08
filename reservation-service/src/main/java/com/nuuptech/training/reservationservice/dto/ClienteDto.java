package com.nuuptech.training.reservationservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDto implements Serializable {

    private Long id;

    private String nombreDenominacion;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String rfc;

    private String domicilio;

    private Date fechaDeNacimiento;

    private String numeroDeLicencia;

    private Date fechaDeCreacion = new Date();

}
