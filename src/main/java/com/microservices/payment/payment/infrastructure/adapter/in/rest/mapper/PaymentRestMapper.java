package com.microservices.payment.payment.infrastructure.adapter.in.rest.mapper;

import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.infrastructure.adapter.in.rest.dto.PaymentCreateRequest;
import com.microservices.payment.payment.infrastructure.adapter.in.rest.dto.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentRestMapper {

    public Payment toDomain(PaymentCreateRequest request){
        return Payment.builder()
                .idOrder(request.getIdOrder())
                .description(request.getDescription())
                .paymentMethod(request.getPaymentMethod())
                .currencyMethod(request.getCurrencyMethod())
                .total(request.getTotal())
                .build();
    }

    public PaymentResponse toResponse(Payment payment){
        return PaymentResponse.builder()
                .idPayment(payment.getIdPayment())
                .idOrder(payment.getIdOrder())
                .idUser(payment.getIdUser())
                .total(payment.getTotal())
                .description(payment.getDescription())
                .paymentReference(payment.getPaymentReference())
                .attempts(payment.getAttempts())
                .createdAt(payment.getCreatedAt())
                .updateAt(payment.getUpdateAt())
                .expireAt(payment.getExpireAt())
                .originIp(payment.getOriginIp())
                .currencyMethod(payment.getCurrencyMethod())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getPaymentStatus())
                .build();
    }
}
