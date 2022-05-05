package com.nuuptech.training.reservationservice.exception;

import lombok.Getter;

@Getter
public class ClientFallbackException extends RuntimeException {

    private final int status;
    private final Object response;

    public ClientFallbackException(String message, int status, Object response) {
        super(message);
        this.status = status;
        this.response = response;
    }

    public static ClientFallbackException from(String message, int status, Object response) {
        return new ClientFallbackException(message, status, response);
    }
}