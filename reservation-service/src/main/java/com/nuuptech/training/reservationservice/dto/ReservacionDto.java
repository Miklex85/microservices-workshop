package com.nuuptech.training.reservationservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nuuptech.training.reservationservice.model.Concepto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservacionDto implements Serializable {

    private Long clienteId;

    private Long vehiculoId;

    private Float kilometrajeInicial;

    private Float kilometrajeFinal;

    private Float nivelCombustibleInicial;

    private Float nivelCombustibleEntrega;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date fechaDeEntrega;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date fechaRealDeEntrega;

    private String observaciones;

    private Set<ConceptoDto> conceptos;

}
