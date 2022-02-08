package com.nuuptech.training.reservationservice.service;

import com.nuuptech.training.reservationservice.model.Concepto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConceptoService {

    public Concepto findById(Long id);

    public List<Concepto> findAll();

    public Page<Concepto> findAll(Pageable pageable);

    public Concepto save(Concepto concepto);

    public Concepto update(Long id, Concepto concepto);

    public boolean deleteById(Long id);

}
