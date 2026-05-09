package com.microservices.payment.payment.domain.port.in;

import com.microservices.payment.payment.domain.model.Payment;

public interface RefundedPaymentPort {
    Payment refunded(Long id);
}
