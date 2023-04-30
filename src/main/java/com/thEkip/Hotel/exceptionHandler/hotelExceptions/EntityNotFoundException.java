package com.thEkip.Hotel.exceptionHandler.hotelExceptions;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException() {
        super("Entity not found");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
