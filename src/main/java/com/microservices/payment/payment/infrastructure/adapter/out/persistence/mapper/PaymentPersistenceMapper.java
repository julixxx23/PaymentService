package com.microservices.payment.payment.infrastructure.adapter.out.persistence.mapper;

import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.infrastructure.adapter.out.persistence.entity.PaymentEntity;
import org.springframework.stereotype.Component;

@Component

public class PaymentPersistenceMapper {

    public Payment toDomain(PaymentEntity entity){
        return Payment.builder()
                .idPayment(entity.getIdPayment())
                .idOrder(entity.getIdOrder())
                .idUser(entity.getIdUser())
                .total(entity.getTotal())
                .description(entity.getDescription())
                .paymentReference(entity.getPaymentReference())
                .attempts(entity.getAttempts())
                .createdAt(entity.getCreatedAt())
                .updateAt(entity.getUpdateAt())
                .expireAt(entity.getExpireAt())
                .originIp(entity.getOriginIp())
                .currencyMethod(entity.getCurrencyMethod())
                .paymentMethod(entity.getPaymentMethod())
                .paymentStatus(entity.getPaymentStatus())
                .build();
    }

    public PaymentEntity toEntity(Payment payment){
        PaymentEntity entity = new PaymentEntity();
        entity.setIdPayment(payment.getIdPayment());
        entity.setIdOrder(payment.getIdOrder());
        entity.setIdUser(payment.getIdUser());
        entity.setTotal(payment.getTotal());
        entity.setDescription(payment.getDescription());
        entity.setPaymentReference(payment.getPaymentReference());
        entity.setAttempts(payment.getAttempts());
        entity.setCreatedAt(payment.getCreatedAt());
        entity.setUpdateAt(payment.getUpdateAt());
        entity.setExpireAt(payment.getExpireAt());
        entity.setOriginIp(payment.getOriginIp());
        entity.setPaymentMethod(payment.getPaymentMethod());
        entity.setPaymentStatus(payment.getPaymentStatus());
        entity.setCurrencyMethod(payment.getCurrencyMethod());
        return entity;
    }
}
