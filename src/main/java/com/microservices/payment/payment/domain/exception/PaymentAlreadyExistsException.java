package com.microservices.payment.payment.domain.exception;

public class PaymentAlreadyExistsException  extends  RuntimeException{
    public PaymentAlreadyExistsException(String message){
        super(message);
    }
}
