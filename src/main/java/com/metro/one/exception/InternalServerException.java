package com.metro.one.exception;

public class InternalServerException extends RuntimeException{

    public InternalServerException(String message) {
        super(message);
    }
}
