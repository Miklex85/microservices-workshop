package com.nuuptech.training.reservationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ConceptoReservacionId implements Serializable {

    @JoinColumn
    @ManyToOne
    @NotNull
    private Concepto concepto;

    @JoinColumn
    @ManyToOne
    @NotNull
    private Reservacion reservacion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConceptoReservacionId that = (ConceptoReservacionId) o;
        return Objects.equals(concepto, that.concepto) && Objects.equals(reservacion, that.reservacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concepto, reservacion);
    }

    @Override
    public String toString() {
        return "ConceptoReservacionId{" +
                "concepto=" + concepto +
                ", reservacion=" + reservacion +
                '}';
    }

}
