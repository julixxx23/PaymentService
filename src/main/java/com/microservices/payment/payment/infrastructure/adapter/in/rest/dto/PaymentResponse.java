package com.microservices.payment.payment.infrastructure.adapter.in.rest.dto;

import com.microservices.payment.payment.domain.model.CurrencyMethod;
import com.microservices.payment.payment.domain.model.PaymentMethod;
import com.microservices.payment.payment.domain.model.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private Long idPayment;
    private Long idOrder;
    private Long idUser;
    private BigDecimal total;
    private String paymentReference;
    private String description;
    private Integer attempts;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private LocalDateTime expiresAt;
    private String originIp;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private CurrencyMethod currencyMethod;

}
