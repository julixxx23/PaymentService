package com.microservices.payment.payment.domain.port.in;

import com.microservices.payment.payment.domain.model.Payment;

public interface ExpirePaymentPort {
    Payment expire(Long id);
}
