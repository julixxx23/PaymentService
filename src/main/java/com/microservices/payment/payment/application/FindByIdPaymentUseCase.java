package com.microservices.payment.payment.application;

import com.microservices.payment.payment.domain.exception.PaymentNotFoundException;
import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.port.in.FindByIdPaymentPort;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindByIdPaymentUseCase implements FindByIdPaymentPort{
    private final PaymentRepositoryPort paymentRepositoryPort;

    @Override
    public Payment findById(Long id){
        return paymentRepositoryPort.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));

    }
}
