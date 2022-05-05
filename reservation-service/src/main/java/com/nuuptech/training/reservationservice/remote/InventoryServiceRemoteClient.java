package com.nuuptech.training.reservationservice.remote;

import com.nuuptech.training.reservationservice.config.RemoteClientConfig;
import com.nuuptech.training.reservationservice.dto.VehiculoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${feign.inventory-service.name}", url="${feign.inventory-service.url}", configuration = RemoteClientConfig.class, fallback = InventoryServiceFallback.class)
public interface InventoryServiceRemoteClient {

    @RequestMapping(method = RequestMethod.GET, value = "/vehiculo/{id}")
    VehiculoDto getVehiculo(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/vehiculo/{id}")
    VehiculoDto updateVehiculo(@PathVariable Long id, @RequestBody VehiculoDto vehiculoDto);

}
