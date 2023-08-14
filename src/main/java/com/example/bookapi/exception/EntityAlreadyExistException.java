package com.example.bookapi.exception;

public class EntityAlreadyExistException extends RuntimeException{

    public EntityAlreadyExistException(String message){
        super(message);
    }
}
