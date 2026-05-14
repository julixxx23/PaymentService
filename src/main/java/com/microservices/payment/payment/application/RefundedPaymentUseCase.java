package com.microservices.payment.payment.application;

import com.microservices.payment.payment.domain.exception.PaymentNotFoundException;
import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.port.in.RefundedPaymentPort;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RefundedPaymentUseCase implements RefundedPaymentPort {
    private final PaymentRepositoryPort paymentRepositoryPort;

    @Override
    public Payment refunded(Long id){
        Payment payment = paymentRepositoryPort.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
        payment.refunded();
        return paymentRepositoryPort.refunded(payment);
    }
}
