package com.jesusvillalbam.springboot.soapproducerservice.domain.exception;

public class BussinessException extends RuntimeException{

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
