package com.microservices.payment.payment.domain.port.in;

import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.shared.domain.model.PageDomain;

public interface FindPaymentTextPort {
    PageDomain<Payment> findText(String text, int page, int size);
}
