package com.nuuptech.training.reservationservice.service;

import com.nuuptech.training.reservationservice.dto.ConfirmacionDto;
import com.nuuptech.training.reservationservice.dto.ReservacionDto;
import com.nuuptech.training.reservationservice.model.Reservacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservacionService {

    public Reservacion findById(Long id);

    public List<Reservacion> findAll();

    public Page<Reservacion> findAll(Pageable pageable);

    public Reservacion save(Reservacion reservacion);

    public boolean deleteById(Long id);

    public ConfirmacionDto reservar(ReservacionDto reservacionDto);

    public ConfirmacionDto entregar(Long id, ReservacionDto reservacionDto);

}
