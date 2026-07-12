package com.microservices.payment.shared.fixture;

import com.microservices.payment.payment.domain.model.CurrencyMethod;
import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.model.PaymentMethod;
import com.microservices.payment.payment.domain.model.PaymentStatus;
import com.microservices.payment.shared.domain.model.PageDomain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PaymentFixture {

    public static Payment aValidPayment() {
        return Payment.builder()
                .idPayment(1L)
                .idOrder(1L)
                .idUser(1L)
                .total(BigDecimal.valueOf(10.00))
                .paymentReference("0000AAAAAA")
                .description("Parking payment")
                .attempts(0)
                .createdAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .updateAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .expireAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .originIp("192.168.1.1")
                .paymentMethod(PaymentMethod.CASH)
                .paymentStatus(PaymentStatus.APPROVED)
                .currencyMethod(CurrencyMethod.GTQ)
                .build();
    }

    public static Payment aPaymentWithoutId() {
        return Payment.builder()
                .idOrder(1L)
                .idUser(1L)
                .total(BigDecimal.valueOf(10.00))
                .paymentReference("0000AAAAAA")
                .description("Parking payment")
                .attempts(0)
                .createdAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .updateAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .expireAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .originIp("192.168.1.1")
                .paymentMethod(PaymentMethod.CASH)
                .paymentStatus(PaymentStatus.APPROVED)
                .currencyMethod(CurrencyMethod.GTQ)
                .build();
    }

    public static Payment aPaymentPending() {
        return Payment.builder()
                .idPayment(1L)
                .idOrder(1L)
                .idUser(1L)
                .total(BigDecimal.valueOf(10.00))
                .paymentReference("0000AAAAAA")
                .description("Parking payment")
                .attempts(0)
                .createdAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .updateAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .expireAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .originIp("192.168.1.1")
                .paymentMethod(PaymentMethod.CASH)
                .paymentStatus(PaymentStatus.PENDING)
                .currencyMethod(CurrencyMethod.GTQ)
                .build();
    }

    public static Payment aPaymentProcessing() {
        return Payment.builder()
                .idPayment(1L)
                .idOrder(1L)
                .idUser(1L)
                .total(BigDecimal.valueOf(10.00))
                .paymentReference("0000AAAAAA")
                .description("Parking payment")
                .attempts(0)
                .createdAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .updateAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .expireAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .originIp("192.168.1.1")
                .paymentMethod(PaymentMethod.CASH)
                .paymentStatus(PaymentStatus.PROCESSING)
                .currencyMethod(CurrencyMethod.GTQ)
                .build();
    }

    public static Payment aPaymentApproved() {
        return Payment.builder()
                .idPayment(1L)
                .idOrder(1L)
                .idUser(1L)
                .total(BigDecimal.valueOf(10.00))
                .paymentReference("0000AAAAAA")
                .description("Parking payment")
                .attempts(0)
                .createdAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .updateAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .expireAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .originIp("192.168.1.1")
                .paymentMethod(PaymentMethod.CASH)
                .paymentStatus(PaymentStatus.APPROVED)
                .currencyMethod(CurrencyMethod.GTQ)
                .build();
    }

    public static Payment aPaymentFailed() {
        return Payment.builder()
                .idPayment(1L)
                .idOrder(1L)
                .idUser(1L)
                .total(BigDecimal.valueOf(10.00))
                .paymentReference("0000AAAAAA")
                .description("Parking payment")
                .attempts(3)
                .createdAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .updateAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .expireAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .originIp("192.168.1.1")
                .paymentMethod(PaymentMethod.CASH)
                .paymentStatus(PaymentStatus.FAILED)
                .currencyMethod(CurrencyMethod.GTQ)
                .build();
    }

    public static Payment aPaymentRefunded() {
        return Payment.builder()
                .idPayment(1L)
                .idOrder(1L)
                .idUser(1L)
                .total(BigDecimal.valueOf(10.00))
                .paymentReference("0000AAAAAA")
                .description("Parking payment")
                .attempts(0)
                .createdAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .updateAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .expireAt(LocalDateTime.of(2024, 3, 22, 10, 23))
                .originIp("192.168.1.1")
                .paymentMethod(PaymentMethod.CASH)
                .paymentStatus(PaymentStatus.REFUNDED)
                .currencyMethod(CurrencyMethod.GTQ)
                .build();
    }

    public static List<Payment> aPaymentList() {
        return List.of(aValidPayment(), aPaymentPending());
    }

    public static PageDomain<Payment> aPaymentPageDomain() {
        return new PageDomain<>(aPaymentList(), 0, 1, 2L);
    }
}