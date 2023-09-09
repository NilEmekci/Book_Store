package com.example.bookapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(EntityNotNullException.class)
    public ResponseEntity<?> entityNotNull(EntityNotNullException entityNotNullException){
        List<String> detail = new ArrayList<>();
        detail.add(entityNotNullException.getMessage());
        ResponseError responseError = new ResponseError("Entity not null", detail);
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFound(EntityNotFoundException entityNotFoundException){
        List<String> detail = new ArrayList<>();
        detail.add(entityNotFoundException.getMessage());
        ResponseError responseError = new ResponseError("Entity Not Found", detail);
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<?> entityAlreadyExist(EntityAlreadyExistException entityAlreadyException){
        List<String> detail = new ArrayList<>();
        detail.add(entityAlreadyException.getMessage());

        ResponseError responseError = new ResponseError("Entity Already Exist", detail);
        return new ResponseEntity<>(responseError, HttpStatus.CONFLICT);

    }


}
