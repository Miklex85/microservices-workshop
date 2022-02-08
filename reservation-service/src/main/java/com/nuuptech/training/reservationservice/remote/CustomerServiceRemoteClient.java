package com.nuuptech.training.reservationservice.remote;

import com.nuuptech.training.reservationservice.config.RemoteClientConfig;
import com.nuuptech.training.reservationservice.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${feign.customer-service.name}", url="${feign.customer-service.url}", configuration = RemoteClientConfig.class)
public interface CustomerServiceRemoteClient {

    @RequestMapping(method = RequestMethod.GET, value = "/cliente/{id}")
    ClienteDto getCliente(@PathVariable Long id);

}
