package com.microservices.payment.payment.application;

import com.microservices.payment.payment.domain.exception.PaymentNotFoundException;
import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.port.in.ExpirePaymentPort;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpirePaymentUseCase implements ExpirePaymentPort {
    private final PaymentRepositoryPort paymentRepositoryPort;

    @Override
    public Payment expire(Long id){
        Payment payment = paymentRepositoryPort.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
        payment.expire();
        return paymentRepositoryPort.save(payment);
    }
}
