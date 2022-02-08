package com.nuuptech.training.inventoryservice.service.impl;

import com.nuuptech.training.inventoryservice.exception.BadRequestException;
import com.nuuptech.training.inventoryservice.exception.EntityNotFoundException;
import com.nuuptech.training.inventoryservice.model.Marca;
import com.nuuptech.training.inventoryservice.repository.MarcaRepository;
import com.nuuptech.training.inventoryservice.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public Marca findById(Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.from(("No existe la marca con id " + id), id.toString()));
    }

    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    public Page<Marca> findAll(Pageable pageable) {
        return marcaRepository.findAll(pageable);
    }

    @Override
    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca update(Long id, Marca marcaConCambios) {
        Marca marca = findById(id);
        marca.setNombre(marcaConCambios.getNombre());
        marca.setActiva(marcaConCambios.isActiva());
        save(marca);
        return marca;
    }

    @Override
    public boolean deleteById(Long id) {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
            return !marcaRepository.existsById(id);
        } else {
            throw new BadRequestException(("No se eliminó el registro. No existe la marca con id " + id));
        }
    }

}
