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
    @Column(name = "id_payment")
    private Long idPayment;

    @Column(name = "id_order")
    private Long idOrder;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "description", nullable = false, length = 225)
    private String description;

    @Column(name = "paymentReference", nullable = false, length = 225)
    private String paymentReference;

    @Column(name = "attempts", nullable = false)
    private Integer attempts;

    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updateAt", nullable = false)
    private LocalDateTime updateAt;

    @Column(name = "expireAt", nullable = false, updatable = false)
    private LocalDateTime expireAt;

    @Column(name = "originIp", nullable = false, length = 45)
    private String originIp;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false, length = 10)
    private CurrencyMethod currencyMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentMethod", nullable = false, length = 10)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentStatus", nullable = false, length = 12)
    private PaymentStatus paymentStatus;



}
