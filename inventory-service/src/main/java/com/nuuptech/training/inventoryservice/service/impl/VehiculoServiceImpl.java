package com.nuuptech.training.inventoryservice.service.impl;

import com.nuuptech.training.inventoryservice.exception.BadRequestException;
import com.nuuptech.training.inventoryservice.exception.EntityNotFoundException;
import com.nuuptech.training.inventoryservice.model.Vehiculo;
import com.nuuptech.training.inventoryservice.repository.VehiculoRepository;
import com.nuuptech.training.inventoryservice.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo findById(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.from(("No existe el vehículo con id " + id), id.toString()));
    }

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Page<Vehiculo> findAllByMarca(Long marcaId, Pageable pageable) {
        return vehiculoRepository.findAllByMarca(marcaId, pageable);
    }

    @Override
    public Page<Vehiculo> findAllBySucursal(Long sucursalId, Pageable pageable) {
        return vehiculoRepository.findAllBySucursal(sucursalId, pageable);
    }

    @Override
    public Page<Vehiculo> findAllMarcaAndSucursal(Long marcaId, Long sucursalId, Pageable pageable) {
        return vehiculoRepository.findAllByMarcaAndSucursal(marcaId, sucursalId, pageable);
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo update(Long id, Vehiculo vehiculoConCambios) {
        Vehiculo vehiculo = findById(id);
        vehiculo.setKilometraje(vehiculoConCambios.getKilometraje());
        vehiculo.setActivo(vehiculoConCambios.isActivo());
        vehiculo.setDisponible(vehiculoConCambios.isDisponible());
        vehiculo.setSucursal(vehiculoConCambios.getSucursal());
        save(vehiculo);
        return vehiculo;
    }

    @Override
    public boolean deleteById(Long id) {
        if (vehiculoRepository.existsById(id)) {
            vehiculoRepository.deleteById(id);
            return !vehiculoRepository.existsById(id);
        } else {
            throw new BadRequestException(("No se eliminó el registro. No existe el vehículo con id " + id));
        }
    }
}
