package com.nuuptech.training.reservationservice.service;

import com.nuuptech.training.reservationservice.model.ConceptoReservacion;
import com.nuuptech.training.reservationservice.model.ConceptoReservacionId;

import java.util.List;

public interface ConceptoReservacionService {

    public ConceptoReservacion findById(ConceptoReservacionId id);

    public List<ConceptoReservacion> findAllByReservacion(Long reservacionId);

    public ConceptoReservacion save(ConceptoReservacion conceptoReservacion);

    public ConceptoReservacion update(ConceptoReservacion conceptoReservacion);

    public boolean deleteById(ConceptoReservacionId id);

    public boolean deleteByReservacion(Long reservacionId);

}
