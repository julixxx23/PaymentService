package com.microservices.payment.payment.application;

import com.microservices.payment.payment.domain.exception.PaymentAlreadyExistsException;
import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.model.PaymentStatus;
import com.microservices.payment.payment.domain.port.in.SavePaymentPort;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class SavePaymentUseCase implements SavePaymentPort {
    private final PaymentRepositoryPort paymentRepositoryPort;


    @Override
    public Payment save(Payment payment){
        if(paymentRepositoryPort.existsActivePaymentByOrderId(payment.getIdOrder())){
            throw new PaymentAlreadyExistsException("Active payment already exists for order id: " + payment.getIdOrder());
        }
        Payment newPayment = Payment.builder()
                .idOrder(payment.getIdOrder())
                .idUser(payment.getIdUser())
                .total(payment.getTotal())
                .description(payment.getDescription())
                .currencyMethod(payment.getCurrencyMethod())
                .paymentMethod(payment.getPaymentMethod())
                .paymentReference("PAY-" + LocalDate.now() + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .attempts(0)
                .paymentStatus(PaymentStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusSeconds(180))
                .build();

        return paymentRepositoryPort.save(newPayment);
    }

}
