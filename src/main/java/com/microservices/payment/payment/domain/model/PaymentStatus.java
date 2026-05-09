package com.microservices.payment.payment.domain.model;

public enum PaymentStatus {
    PENDING,
    PROCESSING,
    APPROVED,
    FAILED,
    REFUNDED
}
