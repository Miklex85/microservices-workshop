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
public class Sucursal implements Serializable {

    @Id
    @Column(name = "id_sucursal")
    @GeneratedValue(generator = "sucursal_id_seq")
    @SequenceGenerator(name = "sucursal_id_seq", sequenceName = "sucursal_id_seq", allocationSize = 1)
    private Long id;

    @Column
    @NotNull
    private String nombre;

    @Column
    @NotNull
    private String direccion;

    @Column
    @NotNull
    private  String horario;

}
