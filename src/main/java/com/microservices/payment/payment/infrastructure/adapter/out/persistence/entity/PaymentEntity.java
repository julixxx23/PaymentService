package com.microservices.payment.payment.infrastructure.adapter.out.persistence.entity;

import com.microservices.payment.payment.domain.model.CurrencyMethod;
import com.microservices.payment.payment.domain.model.PaymentMethod;
import com.microservices.payment.payment.domain.model.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAYMENT")
    private Long idPayment;

    @Column(name = "ID_ORDER")
    private Long idOrder;

    @Column(name = "ID_USER")
    private Long idUser;

    @Column(name = "TOTAL", nullable = false)
    private BigDecimal total;

    @Column(name = "DESCRIPTION", nullable = false, length = 225)
    private String description;

    @Column(name = "PAYMENTREFERENCE", nullable = false, length = 225)
    private String paymentReference;

    @Column(name = "ATTEMPTS", nullable = false)
    private Integer attempts;

    @Column(name = "CREATEDAT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATEAT", nullable = false)
    private LocalDateTime updateAt;

    @Column(name = "EXPIRESAT", nullable = false, updatable = false)
    private LocalDateTime expireAt;

    @Column(name = "ORIGINIP", nullable = false, length = 45)
    private String originIp;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY", nullable = false, length = 10)
    private CurrencyMethod currencyMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENTMETHOD", nullable = false, length = 10)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENTSTATUS", nullable = false, length = 12)
    private PaymentStatus paymentStatus;

}