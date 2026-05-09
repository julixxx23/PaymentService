package com.microservices.payment.payment.application;

import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.port.in.FindPaymentTextPort;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import com.microservices.payment.shared.domain.model.PageDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindByPaymentTextUseCase implements FindPaymentTextPort{
    private final PaymentRepositoryPort paymentRepositoryPort;

    @Override
    public PageDomain<Payment> findText(String text, int page, int size){
        return paymentRepositoryPort.findText(text, page, size);
    }
}
