package com.nuuptech.training.reservationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Concepto implements Serializable {

    @Id
    @Column(name = "id_concepto")
    @GeneratedValue(generator = "concepto_id_seq")
    @SequenceGenerator(name = "concepto_id_seq", sequenceName = "concepto_id_seq", allocationSize = 1)
    private Long id;

    @Column
    @NotNull
    private String nombre;

    @Column
    @NotNull
    private boolean activo;

}
