package com.nuuptech.training.customerservice.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    public static BadRequestException from(String message) {
        return new BadRequestException(message);
    }
}