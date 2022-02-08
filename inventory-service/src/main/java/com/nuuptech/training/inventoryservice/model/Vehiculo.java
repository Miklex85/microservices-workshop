package com.nuuptech.training.inventoryservice.model;

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
public class Vehiculo implements Serializable {

    @Id
    @Column(name = "id_vehiculo")
    @GeneratedValue(generator = "vehiculo_id_seq")
    @SequenceGenerator(name = "vehiculo_id_seq", sequenceName = "vehiculo_id_seq", allocationSize = 1)
    private Long id;

    @Column
    @NotNull
    private String modelo;

    @Column
    @NotNull
    private String anio;

    @Column
    @NotNull
    private String kilometraje;

    @JoinColumn
    @ManyToOne
    @NotNull
    private Marca marca;

    @JoinColumn
    @ManyToOne
    @NotNull
    private Sucursal sucursal;

    @Column
    @NotNull
    private boolean disponible = true;

    @Column
    @NotNull
    private boolean activo = true;

}
