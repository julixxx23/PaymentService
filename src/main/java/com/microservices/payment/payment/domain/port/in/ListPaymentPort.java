package com.microservices.payment.payment.domain.port.in;

import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.shared.domain.model.PageDomain;

public interface ListPaymentPort {
    PageDomain<Payment> list (int page, int size);
}
