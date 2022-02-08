package com.nuuptech.training.reservationservice.exception;

import lombok.Getter;

@Getter
public class RemoteClientException extends RuntimeException {

    private final int status;
    private final Object response;

    public RemoteClientException(String message, int status, Object response) {
        super(message);
        this.status = status;
        this.response = response;
    }

    public static RemoteClientException from(String message, int status, Object response) {
        return new RemoteClientException(message, status, response);
    }
}