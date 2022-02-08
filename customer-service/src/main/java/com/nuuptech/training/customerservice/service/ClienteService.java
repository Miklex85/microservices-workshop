package com.nuuptech.training.customerservice.service;

import com.nuuptech.training.customerservice.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

    public Cliente findById(Long id);

    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    public Cliente save(Cliente cliente);

    public Cliente update(Long id, Cliente cliente);

    public boolean deleteById(Long id);

}
