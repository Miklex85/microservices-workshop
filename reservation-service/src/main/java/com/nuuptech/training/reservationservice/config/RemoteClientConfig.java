package com.nuuptech.training.reservationservice.config;

import com.nuuptech.training.reservationservice.exception.RemoteClientException;
import feign.Client;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

import static feign.FeignException.errorStatus;

public class RemoteClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            InputStream initialStream;
            byte[] targetArray;
            String result = "";
            try {
                initialStream = response.body().asInputStream();
                targetArray = new byte[initialStream.available()];
                initialStream.read(targetArray);
                result = new String(targetArray);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (response.status() >= 400 && response.status() <= 499) {
                return new RemoteClientException(response.reason(), response.status(), result);
            }
            if (response.status() >= 500 && response.status() <= 599) {
                return new RuntimeException(response.reason());
            }
            return errorStatus(methodKey, response);
        };
    }
}

