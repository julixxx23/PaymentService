package com.microservices.payment.payment.application;

import com.microservices.payment.payment.domain.exception.PaymentNotFoundException;
import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.port.in.AdvanceStatusPaymentPort;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdvanceStatusUseCase implements AdvanceStatusPaymentPort {
    private final PaymentRepositoryPort paymentRepositoryPort;

    @Override
    public Payment advance(Long id){
        Payment payment = paymentRepositoryPort.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
        payment.advanceStatus();
        return paymentRepositoryPort.save(payment);
    }

}
