package com.microservices.payment.payment.domain.port.in;

import com.microservices.payment.payment.domain.model.Payment;

public interface FailedPaymentPort {
    Payment failed(Long id);
}
