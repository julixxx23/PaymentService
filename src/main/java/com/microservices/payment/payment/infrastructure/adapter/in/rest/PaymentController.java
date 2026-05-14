package com.microservices.payment.payment.infrastructure.adapter.in.rest;

import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.port.in.*;
import com.microservices.payment.payment.infrastructure.adapter.in.rest.dto.PaymentCreateRequest;
import com.microservices.payment.payment.infrastructure.adapter.in.rest.dto.PaymentResponse;
import com.microservices.payment.payment.infrastructure.adapter.in.rest.mapper.PaymentRestMapper;
import com.microservices.payment.shared.domain.model.PageDomain;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final AdvanceStatusPaymentPort advanceStatusPaymentPort;
    private final ExpirePaymentPort expirePaymentPort;
    private final FailedPaymentPort failedPaymentPort;
    private final FindByIdPaymentPort findByIdPaymentPort;
    private final FindPaymentTextPort findPaymentTextPort;
    private final ListPaymentPort listPaymentPort;
    private final RefundedPaymentPort refundedPaymentPort;
    private final SavePaymentPort savePaymentPort;
    private final PaymentRestMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long id) {
        Payment payment = findByIdPaymentPort.findById(id);
        return ResponseEntity.ok(mapper.toResponse(payment));
    }

    @GetMapping
    public ResponseEntity<PageDomain<PaymentResponse>> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageDomain<Payment> pageDomain = listPaymentPort.list(page, size);
        PageDomain<PaymentResponse> responsePageDomain = new PageDomain<>(
                pageDomain.content().stream().map(mapper::toResponse).toList(),
                pageDomain.currentPage(),
                pageDomain.totalPages(),
                pageDomain.totalElements()
        );
        return ResponseEntity.ok(responsePageDomain);
    }

    @GetMapping("/search")
    public ResponseEntity<PageDomain<PaymentResponse>> findText(
            @RequestParam String text,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageDomain<Payment> pageDomain = findPaymentTextPort.findText(text, page, size);
        PageDomain<PaymentResponse> responsePageDomain = new PageDomain<>(
                pageDomain.content().stream().map(mapper::toResponse).toList(),
                pageDomain.currentPage(),
                pageDomain.totalPages(),
                pageDomain.totalElements()
        );
        return ResponseEntity.ok(responsePageDomain);
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> save(@Valid @RequestBody PaymentCreateRequest request) {
        Payment payment = savePaymentPort.save(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(payment));
    }

    @PatchMapping("/{id}/advance")
    public ResponseEntity<PaymentResponse> advance(@PathVariable Long id) {
        Payment payment = advanceStatusPaymentPort.advance(id);
        return ResponseEntity.ok(mapper.toResponse(payment));
    }

    @PatchMapping("/{id}/expire")
    public ResponseEntity<PaymentResponse> expire(@PathVariable Long id) {
        Payment payment = expirePaymentPort.expire(id);
        return ResponseEntity.ok(mapper.toResponse(payment));
    }

    @PatchMapping("/{id}/failed")
    public ResponseEntity<PaymentResponse> failed(@PathVariable Long id) {
        Payment payment = failedPaymentPort.failed(id);
        return ResponseEntity.ok(mapper.toResponse(payment));
    }

    @PatchMapping("/{id}/refunded")
    public ResponseEntity<PaymentResponse> refunded(@PathVariable Long id) {
        Payment payment = refundedPaymentPort.refunded(id);
        return ResponseEntity.ok(mapper.toResponse(payment));
    }
}