package com.nuuptech.training.reservationservice.service.impl;

import com.nuuptech.training.reservationservice.exception.BadRequestException;
import com.nuuptech.training.reservationservice.exception.EntityNotFoundException;
import com.nuuptech.training.reservationservice.model.Concepto;
import com.nuuptech.training.reservationservice.repository.ConceptoRepository;
import com.nuuptech.training.reservationservice.service.ConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConceptoServiceImpl implements ConceptoService {

    @Autowired
    ConceptoRepository conceptoRepository;

    @Override
    public Concepto findById(Long id) {
        return conceptoRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.from(("No existe el concepto con id " + id), id.toString()));
    }

    @Override
    public List<Concepto> findAll() {
        return conceptoRepository.findAll();
    }

    @Override
    public Page<Concepto> findAll(Pageable pageable) {
        return conceptoRepository.findAll(pageable);
    }

    @Override
    public Concepto save(Concepto concepto) {
        return conceptoRepository.save(concepto);
    }

    @Override
    public Concepto update(Long id, Concepto conceptoConCambios) {
        Concepto concepto = findById(conceptoConCambios.getId());
        concepto.setNombre(conceptoConCambios.getNombre());
        concepto.setActivo(conceptoConCambios.isActivo());
        save(concepto);
        return concepto;
    }

    @Override
    public boolean deleteById(Long id) {
        if (conceptoRepository.existsById(id)) {
            conceptoRepository.deleteById(id);
            return !conceptoRepository.existsById(id);
        } else {
            throw new BadRequestException(("No se eliminó el registro. No existe el concepto con id " + id));
        }
    }
}
