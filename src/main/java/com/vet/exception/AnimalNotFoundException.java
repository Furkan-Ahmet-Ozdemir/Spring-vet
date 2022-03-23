package com.vet.exception;

public class AnimalNotFoundException extends Throwable {
    public AnimalNotFoundException(String message) {
        super(message);
    }
}
