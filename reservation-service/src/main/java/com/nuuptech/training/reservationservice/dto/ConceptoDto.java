package com.nuuptech.training.reservationservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ConceptoDto implements Serializable {

    private Long conceptoId;

    private Integer cantidad;

    private Double importe;
}
