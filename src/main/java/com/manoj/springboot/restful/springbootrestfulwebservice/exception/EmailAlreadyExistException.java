package com.manoj.springboot.restful.springbootrestfulwebservice.exception;

public class EmailAlreadyExistException extends RuntimeException {
    private final String message;

    public EmailAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
