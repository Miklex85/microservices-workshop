package com.nuuptech.training.reservationservice.service.impl;

import com.nuuptech.training.reservationservice.dto.ClienteDto;
import com.nuuptech.training.reservationservice.dto.ConfirmacionDto;
import com.nuuptech.training.reservationservice.dto.ReservacionDto;
import com.nuuptech.training.reservationservice.dto.VehiculoDto;
import com.nuuptech.training.reservationservice.exception.BadRequestException;
import com.nuuptech.training.reservationservice.exception.EntityNotFoundException;
import com.nuuptech.training.reservationservice.exception.RemoteClientException;
import com.nuuptech.training.reservationservice.model.ConceptoReservacion;
import com.nuuptech.training.reservationservice.model.ConceptoReservacionId;
import com.nuuptech.training.reservationservice.model.Reservacion;
import com.nuuptech.training.reservationservice.remote.CustomerServiceRemoteClient;
import com.nuuptech.training.reservationservice.remote.InventoryServiceRemoteClient;
import com.nuuptech.training.reservationservice.repository.ReservacionRepository;
import com.nuuptech.training.reservationservice.service.ConceptoReservacionService;
import com.nuuptech.training.reservationservice.service.ConceptoService;
import com.nuuptech.training.reservationservice.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
@Transactional
public class ReservacionServiceImpl implements ReservacionService {

    @Autowired
    ReservacionRepository reservacionRepository;

    @Autowired
    ConceptoReservacionService conceptoReservacionService;

    @Autowired
    ConceptoService conceptoService;

    @Autowired
    CustomerServiceRemoteClient customerServiceRemoteClient;

    @Autowired
    InventoryServiceRemoteClient inventoryServiceRemoteClient;

    @Override
    public Reservacion findById(Long id) {
        return reservacionRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.from(("No existe la reservación con id " + id), id.toString()));
    }

    @Override
    public List<Reservacion> findAll() {
        return reservacionRepository.findAll();
    }

    @Override
    public Page<Reservacion> findAll(Pageable pageable) {
        return reservacionRepository.findAll(pageable);
    }

    @Override
    public Reservacion save(Reservacion reservacion) {
        return reservacionRepository.save(reservacion);
    }

    @Override
    public boolean deleteById(Long id) {
        if(reservacionRepository.existsById(id)) {
            conceptoReservacionService.deleteByReservacion(id);
            reservacionRepository.deleteById(id);
            return !reservacionRepository.existsById(id);
        } else {
            throw new BadRequestException(("No se eliminó el registro. No existe la reservación con id " + id));
        }
    }

    @Override
    public ConfirmacionDto reservar(ReservacionDto reservacionDto) {
        ClienteDto clienteDto;
        VehiculoDto vehiculoDto;
        try {
            clienteDto = customerServiceRemoteClient.getCliente(reservacionDto.getClienteId());
        } catch (RemoteClientException rce) {
            throw new BadRequestException("El cliente especificado no existe.");
        }
        try {
            vehiculoDto = inventoryServiceRemoteClient.getVehiculo(reservacionDto.getVehiculoId());
        } catch (RemoteClientException rce) {
            throw new BadRequestException("El vehículo especificado no existe");
        }
        if(vehiculoDto.isDisponible()) {
            try {
                ConfirmacionDto confirmacionDto = new ConfirmacionDto();
                Reservacion reservacion = new Reservacion();
                reservacion.setClienteId(reservacionDto.getClienteId());
                reservacion.setVehiculoId(reservacionDto.getVehiculoId());
                reservacion.setFechaDeEntrega(reservacionDto.getFechaDeEntrega());
                reservacion.setKilometrajeInicial(Float.valueOf(vehiculoDto.getKilometraje()));
                reservacion.setNivelCombustibleInicial(reservacionDto.getNivelCombustibleInicial());
                reservacion.setObservaciones(reservacionDto.getObservaciones());
                save(reservacion);
                reservacionDto.getConceptos().forEach(concepto -> {
                    ConceptoReservacion conceptoReservacion = new ConceptoReservacion();
                    conceptoReservacion.setId(new ConceptoReservacionId(conceptoService.findById(concepto.getConceptoId()), reservacion));
                    conceptoReservacion.setImporte(concepto.getImporte());
                    conceptoReservacion.setCantidad(concepto.getCantidad());
                    conceptoReservacionService.save(conceptoReservacion);
                });
                vehiculoDto.setDisponible(false);
                inventoryServiceRemoteClient.updateVehiculo(reservacionDto.getVehiculoId(), vehiculoDto);
                confirmacionDto.setFolioReservacion(reservacion.getId());
                confirmacionDto.setFechaReservacion(reservacion.getFechaDeCreacion());
                confirmacionDto.setMensaje("La reservación se ha realizado correctamente");
                return confirmacionDto;
            } catch (ConstraintViolationException cve) {
                vehiculoDto.setDisponible(true);
                inventoryServiceRemoteClient.updateVehiculo(reservacionDto.getVehiculoId(), vehiculoDto);
                throw new BadRequestException(("Petición mal formada o incompleta. No se registró la reservación."));
            }
        } else {
            throw new BadRequestException(("El vehículo con id " + reservacionDto.getVehiculoId() + " no está disponible para ser rentado."));
        }
    }

    @Override
    public ConfirmacionDto entregar(Long id, ReservacionDto reservacionDto) {
        ConfirmacionDto confirmacionDto = new ConfirmacionDto();
        Reservacion reservacion = findById(id);
        reservacion.setKilometrajeFinal(reservacionDto.getKilometrajeFinal());
        reservacion.setNivelCombustibleEntrega(reservacionDto.getNivelCombustibleEntrega());
        reservacion.setFechaRealDeEntrega(reservacionDto.getFechaRealDeEntrega());
        reservacion.setObservaciones(reservacionDto.getObservaciones());
        save(reservacion);
        VehiculoDto vehiculoDto = inventoryServiceRemoteClient.getVehiculo(reservacion.getVehiculoId());
        vehiculoDto.setDisponible(true);
        vehiculoDto.setKilometraje(String.valueOf(reservacionDto.getKilometrajeFinal()));
        inventoryServiceRemoteClient.updateVehiculo(reservacion.getVehiculoId(), vehiculoDto);
        confirmacionDto.setFolioReservacion(reservacion.getId());
        confirmacionDto.setMensaje("Se ha realizado la entrega del vehículo correctamente");
        return confirmacionDto;
    }

}
