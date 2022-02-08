package com.nuuptech.training.inventoryservice.service;

import com.nuuptech.training.inventoryservice.model.Marca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MarcaService {

    public Marca findById(Long id);

    public List<Marca> findAll();

    public Page<Marca> findAll(Pageable pageable);

    public Marca save(Marca marca);

    public Marca update(Long id, Marca marca);

    public boolean deleteById(Long id);

}
