package com.nuuptech.training.inventoryservice.service;

import com.nuuptech.training.inventoryservice.model.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehiculoService {

    public Vehiculo findById(Long id);

    public List<Vehiculo> findAll();

    public Page<Vehiculo> findAllByMarca(Long marcaId, Pageable pageable);

    public Page<Vehiculo> findAllBySucursal(Long sucursalId, Pageable pageable);

    public Page<Vehiculo> findAllMarcaAndSucursal(Long marcaId, Long sucursalId, Pageable pageable);

    public Vehiculo save(Vehiculo vehiculo);

    public Vehiculo update(Long id, Vehiculo vehiculo);

    public boolean deleteById(Long id);

}
