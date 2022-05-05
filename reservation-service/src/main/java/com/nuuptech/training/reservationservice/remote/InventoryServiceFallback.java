package com.nuuptech.training.reservationservice.remote;

import com.nuuptech.training.reservationservice.dto.VehiculoDto;
import com.nuuptech.training.reservationservice.exception.ClientFallbackException;
import org.springframework.stereotype.Component;

@Component
public class InventoryServiceFallback implements InventoryServiceRemoteClient {

    @Override
    public VehiculoDto getVehiculo(Long id) {
        throw new ClientFallbackException("No se pudo obtener el vehículo. Intente de nuevo más tarde.", 503, "");
    }

    @Override
    public VehiculoDto updateVehiculo(Long id, VehiculoDto vehiculoDto) {
        throw new ClientFallbackException("No se pudo concretar la transacción. Intente de nuevo más tarde.", 503, "");
    }
}
