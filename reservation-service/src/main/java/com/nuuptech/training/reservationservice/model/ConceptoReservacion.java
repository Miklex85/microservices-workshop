package com.nuuptech.training.reservationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ConceptoReservacion implements Serializable {

    @EmbeddedId
    private ConceptoReservacionId id;

    @Column
    @NotNull
    private Integer cantidad;

    @Column
    @NotNull
    private Double importe;

}
