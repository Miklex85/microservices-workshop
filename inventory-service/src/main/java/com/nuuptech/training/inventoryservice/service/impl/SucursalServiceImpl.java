package com.nuuptech.training.inventoryservice.service.impl;

import com.nuuptech.training.inventoryservice.exception.BadRequestException;
import com.nuuptech.training.inventoryservice.exception.EntityNotFoundException;
import com.nuuptech.training.inventoryservice.model.Sucursal;
import com.nuuptech.training.inventoryservice.repository.SucursalRepository;
import com.nuuptech.training.inventoryservice.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    @Override
    public Sucursal findById(Long id) {
        return sucursalRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.from(("No existe la sucursal con id " + id), id.toString()));
    }

    @Override
    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    @Override
    public Page<Sucursal> findAll(Pageable pageable) {
        return sucursalRepository.findAll(pageable);
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal update(Long id, Sucursal sucursalConCambios) {
        Sucursal sucursal = findById(id);
        sucursal.setNombre(sucursalConCambios.getNombre());
        sucursal.setDireccion(sucursalConCambios.getDireccion());
        sucursal.setHorario(sucursalConCambios.getHorario());
        save(sucursal);
        return sucursal;
    }

    @Override
    public boolean deleteById(Long id) {
        if (sucursalRepository.existsById(id)) {
            sucursalRepository.deleteById(id);
            return !sucursalRepository.existsById(id);
        } else {
            throw new BadRequestException(("No se eliminó el registro. No existe la sucursal con id " + id));
        }
    }
}
