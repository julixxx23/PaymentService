package com.microservices.payment.payment.infrastructure.adapter.out.persistence.repository;


import com.microservices.payment.payment.infrastructure.adapter.out.persistence.entity.PaymentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {
    boolean existsActivePaymentByIdOrder(Long orderId);
    Page<PaymentEntity> findByPaymentReferenceContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String ref, String desc, Pageable pageable);
}
