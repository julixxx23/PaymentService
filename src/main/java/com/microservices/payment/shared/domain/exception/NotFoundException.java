package com.microservices.payment.shared.domain.exception;

public class NotFoundException extends RuntimeException {
    protected NotFoundException (String message){
        super(message);
    }
}
