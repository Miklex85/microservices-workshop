package com.nuuptech.training.reservationservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfirmacionDto implements Serializable {

    private Long folioReservacion;

    private Date fechaReservacion;

    private String mensaje;

}
