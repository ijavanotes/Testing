package com.example.travelsearch.exception;

public class SystemErrorException  extends  RuntimeException{
    public SystemErrorException() {
    }

    public SystemErrorException(String message) {
        super(message);
    }
}
