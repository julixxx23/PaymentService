package com.microservices.payment.payment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

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

    public void advanceStatus(){
        switch (paymentStatus){
            case PENDING -> paymentStatus = PaymentStatus.PROCESSING;
            case PROCESSING -> paymentStatus = PaymentStatus.APPROVED;
            default -> throw new IllegalStateException("Cannot advance from state: " + paymentStatus);
        }
    }

    public void failed(){
        if(paymentStatus != PaymentStatus.PROCESSING){
            throw new IllegalStateException("Cannot process payment, invalid state");
        }
        paymentStatus = PaymentStatus.FAILED;
        attempts ++;
        updateAt = LocalDateTime.now();
    }

    public void refunded(){
        if(paymentStatus != PaymentStatus.APPROVED){
            throw new IllegalStateException("Payment cannot be refunded");
        }
        paymentStatus = PaymentStatus.REFUNDED;
        updateAt = LocalDateTime.now();
    }
    public void expire(){
        if(paymentStatus != PaymentStatus.PENDING){
            throw new IllegalStateException("Payment cannot be expired");
        }
        paymentStatus = PaymentStatus.FAILED;
        updateAt = LocalDateTime.now();
    }



}
