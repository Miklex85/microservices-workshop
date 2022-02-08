package com.nuuptech.training.reservationservice.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException  extends RuntimeException {

    private final String id;

    public EntityNotFoundException(String message, String id) {
        super(message);
        this.id = id;
    }

    public static EntityNotFoundException from(String message, String id) {
        return new EntityNotFoundException(message, id);
    }
}
