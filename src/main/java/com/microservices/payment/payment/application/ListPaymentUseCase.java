package com.microservices.payment.payment.application;

import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.port.in.ListPaymentPort;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import com.microservices.payment.shared.domain.model.PageDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListPaymentUseCase implements ListPaymentPort{
    private final PaymentRepositoryPort paymentRepositoryPort;

    @Override
    public PageDomain<Payment> list(int page, int size){
        return paymentRepositoryPort.list(page, size);
    }
}
