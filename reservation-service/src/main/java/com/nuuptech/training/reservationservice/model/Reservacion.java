package com.nuuptech.training.reservationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Reservacion implements Serializable {

    @Id
    @Column(name = "id_reservacion")
    @GeneratedValue(generator = "reservacion_id_seq")
    @SequenceGenerator(name = "reservacion_id_seq", sequenceName = "reservacion_id_seq", allocationSize = 1)
    private Long id;

    @Column
    @NotNull
    private Date fechaDeCreacion = new Date();

    @Column
    @NotNull
    private Long clienteId;

    @Column
    @NotNull
    private Long vehiculoId;

    @Column
    @NotNull
    private Float kilometrajeInicial;

    @Column
    private Float kilometrajeFinal;

    @Column
    @NotNull
    private Float nivelCombustibleInicial;

    @Column
    private Float nivelCombustibleEntrega;

    @Column
    @NotNull
    private Date fechaDeEntrega;

    @Column
    private Date fechaRealDeEntrega;

    @Column
    private String observaciones;

}
