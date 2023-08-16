package com.example.bookapi.exception;

public class EntityNotNullException extends RuntimeException {
    public EntityNotNullException(String message){
        super(message);
    }
}

