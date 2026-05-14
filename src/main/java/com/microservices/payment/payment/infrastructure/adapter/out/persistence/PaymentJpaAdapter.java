package com.microservices.payment.payment.infrastructure.adapter.out.persistence;

import com.microservices.payment.payment.domain.model.Payment;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import com.microservices.payment.payment.infrastructure.adapter.out.persistence.entity.PaymentEntity;
import com.microservices.payment.payment.infrastructure.adapter.out.persistence.mapper.PaymentPersistenceMapper;
import com.microservices.payment.payment.infrastructure.adapter.out.persistence.repository.PaymentJpaRepository;
import com.microservices.payment.shared.domain.model.PageDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@RequiredArgsConstructor
public class PaymentJpaAdapter implements PaymentRepositoryPort {

    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentPersistenceMapper mapper;

    @Override
    public Payment save(Payment payment){
        return mapper.toDomain(paymentJpaRepository.save(mapper.toEntity(payment)));
    }

    @Override
    public Optional<Payment> findById(Long id){
        return paymentJpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public PageDomain<Payment> list(int page, int size){
        Page<PaymentEntity> entityPage = paymentJpaRepository.findAll(PageRequest.of(page, size));
        Page<Payment> pages = entityPage.map(mapper::toDomain);
        return new PageDomain<>(
                pages.getContent(),
                pages.getNumber(),
                pages.getTotalPages(),
                pages.getTotalElements()
        );
    }

    @Override
    public PageDomain<Payment> findText(String text, int page, int size){
        Page<PaymentEntity> entityPage = paymentJpaRepository.findByPaymentReferenceContainingIgnoreCaseOrDescriptionContainingIgnoreCase
                (text, text, PageRequest.of(page, size));
        Page<Payment> pages = entityPage.map(mapper::toDomain);
        return new PageDomain<>(
                pages.getContent(),
                pages.getNumber(),
                pages.getTotalPages(),
                pages.getTotalElements()
        );
    }

    @Override
    public Payment expire(Payment payment){
        return mapper.toDomain(paymentJpaRepository.save(mapper.toEntity(payment)));
    }

    @Override
    public Payment advance(Payment payment){
        return mapper.toDomain(paymentJpaRepository.save(mapper.toEntity(payment)));
    }

    @Override
    public Payment failed(Payment payment){
        return mapper.toDomain(paymentJpaRepository.save(mapper.toEntity(payment)));
    }

    @Override
    public Payment refunded(Payment payment){
        return mapper.toDomain(paymentJpaRepository.save(mapper.toEntity(payment)));
    }

    @Override
    public boolean existsActivePaymentByOrderId(Long orderId){
        return paymentJpaRepository.existsActivePaymentByIdOrder(orderId);
    }


}
