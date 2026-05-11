package com.microservices.payment.payment.infrastructure.adapter.in.rest.dto;

import com.microservices.payment.payment.domain.model.CurrencyMethod;
import com.microservices.payment.payment.domain.model.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreateRequest {

    @NotNull(message = "Order id is required")
    private Long idOrder;

    @NotBlank(message = "Description is required")
    @Size(max = 225, message = "Description must not exceed 225 characters")
    private String description;

    @NotNull(message = "Payment method is required")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Currency method is required")
    private CurrencyMethod currencyMethod;

    @NotNull(message = "Total is required")
    @DecimalMin(value = "0.01", message = "Total must be greater than zero")
    private BigDecimal total;
}