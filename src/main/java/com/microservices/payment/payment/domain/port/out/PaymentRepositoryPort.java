package com.microservices.payment.payment.domain.port.out;

import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.shared.domain.model.PageDomain;

import java.util.Optional;

public interface PaymentRepositoryPort {
    Payment save(Payment payment);
    Payment update(Long id, Payment payment);
    Optional<Payment> findById(Long id);
    PageDomain<Payment> findText(String text, int page, int size);
    PageDomain<Payment> list(int page, int size);
    boolean existsActivePaymentByOrderId(Long orderId);

}
