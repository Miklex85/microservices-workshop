package com.nuuptech.training.inventoryservice.service;

import com.nuuptech.training.inventoryservice.model.Sucursal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SucursalService {

    public Sucursal findById(Long id);

    public List<Sucursal> findAll();

    public Page<Sucursal> findAll(Pageable pageable);

    public Sucursal save(Sucursal sucursal);

    public Sucursal update(Long id, Sucursal sucursal);

    public boolean deleteById(Long id);

}
