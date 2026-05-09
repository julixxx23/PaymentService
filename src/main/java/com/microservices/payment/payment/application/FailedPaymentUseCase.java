package com.microservices.payment.payment.application;

import com.microservices.payment.payment.domain.exception.PaymentNotFoundException;
import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.port.in.FailedPaymentPort;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FailedPaymentUseCase implements FailedPaymentPort {
    private final PaymentRepositoryPort paymentRepositoryPort;

    @Override
    public Payment failed(Long id){
        Payment payment = paymentRepositoryPort.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
        payment.failed();
        return paymentRepositoryPort.save(payment);
    }
}
