package com.nuuptech.training.reservationservice.remote;

import com.nuuptech.training.reservationservice.dto.ClienteDto;
import com.nuuptech.training.reservationservice.exception.ClientFallbackException;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceFallback implements CustomerServiceRemoteClient {

    @Override
    public ClienteDto getCliente(Long id) {
        throw new ClientFallbackException("No se pudo obtener el cliente Intente de nuevo más tarde.", 503, "");
    }

}
