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
public class Marca implements Serializable {

    @Id
    @Column(name = "id_marca")
    @GeneratedValue(generator = "marca_id_seq")
    @SequenceGenerator(name = "marca_id_seq", sequenceName = "marca_id_seq", allocationSize = 1)
    private Long id;

    @Column
    @NotNull
    private String nombre;

    @Column
    @NotNull
    private boolean activa;

}
