package com.nuuptech.training.customerservice.service.impl;

import com.nuuptech.training.customerservice.exception.BadRequestException;
import com.nuuptech.training.customerservice.exception.EntityNotFoundException;
import com.nuuptech.training.customerservice.model.Cliente;
import com.nuuptech.training.customerservice.repository.ClienteRepository;
import com.nuuptech.training.customerservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.from(("No existe el cliente con id " + id), id.toString()));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Long id, Cliente clienteConCambios) {
        Cliente cliente = findById(id);
        cliente.setNombreDenominacion(clienteConCambios.getNombreDenominacion());
        cliente.setApellidoPaterno(clienteConCambios.getApellidoPaterno());
        cliente.setApellidoMaterno(clienteConCambios.getApellidoMaterno());
        cliente.setDomicilio(clienteConCambios.getDomicilio());
        cliente.setFechaDeNacimiento(clienteConCambios.getFechaDeNacimiento());
        cliente.setRfc(clienteConCambios.getRfc());
        cliente.setNumeroDeLicencia(clienteConCambios.getNumeroDeLicencia());
        save(cliente);
        return cliente;
    }

    @Override
    public boolean deleteById(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return !clienteRepository.existsById(id);
        } else {
            throw new BadRequestException(("No se eliminó el registro. No existe el cliente con id " + id));
        }
    }
}
