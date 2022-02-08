package com.nuuptech.training.customerservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Cliente implements Serializable {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(generator = "cliente_id_seq")
    @SequenceGenerator(name = "cliente_id_seq", sequenceName = "cliente_id_seq", allocationSize = 1)
    private Long id;

    @Column
    @NotNull
    private String nombreDenominacion;

    @Column
    private String apellidoPaterno;

    @Column
    private String apellidoMaterno;

    @Column
    @NotNull
    private String rfc;

    @Column
    @NotNull
    private String domicilio;

    @Column
    private Date fechaDeNacimiento;

    @Column
    @NotBlank
    private String numeroDeLicencia;

    @Column
    @NotNull
    private Date fechaDeCreacion = new Date();

}
