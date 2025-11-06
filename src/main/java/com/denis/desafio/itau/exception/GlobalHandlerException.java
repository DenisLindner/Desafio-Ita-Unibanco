package com.denis.desafio.itau.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<Void> handleUnprocessableEntityException() {
        return ResponseEntity.status(422).build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleException() {
        return ResponseEntity.status(400).build();
    }
}
