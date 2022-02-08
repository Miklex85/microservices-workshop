package com.nuuptech.training.reservationservice.service.impl;

import com.nuuptech.training.reservationservice.exception.BadRequestException;
import com.nuuptech.training.reservationservice.exception.EntityNotFoundException;
import com.nuuptech.training.reservationservice.model.ConceptoReservacion;
import com.nuuptech.training.reservationservice.model.ConceptoReservacionId;
import com.nuuptech.training.reservationservice.repository.ConceptoReservacionRepository;
import com.nuuptech.training.reservationservice.service.ConceptoReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConceptoReservacionServiceImpl implements ConceptoReservacionService {

    @Autowired
    ConceptoReservacionRepository conceptoReservacionRepository;

    @Override
    public ConceptoReservacion findById(ConceptoReservacionId id) {
        return conceptoReservacionRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.from(("No existe el concepto de reservacion con id " + id), id.toString()));
    }

    @Override
    public List<ConceptoReservacion> findAllByReservacion(Long reservacionId) {
        return conceptoReservacionRepository.findAllByReservacion(reservacionId);
    }

    @Override
    public ConceptoReservacion save(ConceptoReservacion conceptoReservacion) {
        return conceptoReservacionRepository.save(conceptoReservacion);
    }

    @Override
    public ConceptoReservacion update(ConceptoReservacion conceptoReservacionConCambios) {
        if(conceptoReservacionConCambios.getId() != null) {
            ConceptoReservacion conceptoReservacion = findById(conceptoReservacionConCambios.getId());
            conceptoReservacion.setCantidad(conceptoReservacionConCambios.getCantidad());
            conceptoReservacion.setImporte(conceptoReservacionConCambios.getImporte());
            save(conceptoReservacion);
            return conceptoReservacion;
        } else {
            throw new BadRequestException("No se actualizó el registro. Id del concepto de la reservacion no proporcionado.");
        }
    }

    @Override
    public boolean deleteById(ConceptoReservacionId id) {
        if(conceptoReservacionRepository.existsById(id)) {
            conceptoReservacionRepository.deleteById(id);
            return !conceptoReservacionRepository.existsById(id);
        } else {
            throw new BadRequestException(("No se eliminó el registro. No existe el concepto de reservación con id " + id));
        }
    }

    @Override
    public boolean deleteByReservacion(Long reservacionId) {
        if(conceptoReservacionRepository.countByReservacion(reservacionId) > 0) {
            conceptoReservacionRepository.deleteAllByReservacion(reservacionId);
            return !(conceptoReservacionRepository.countByReservacion(reservacionId) > 0);
        } else {
            throw new BadRequestException(("No se eliminó el registro. No existe el concepto de reservación con id " + reservacionId));
        }
    }
}
