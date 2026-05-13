package com.microservices.payment.payment.infrastructure.config;

import com.microservices.payment.payment.application.*;
import com.microservices.payment.payment.domain.port.in.*;
import com.microservices.payment.payment.domain.port.out.PaymentRepositoryPort;
import com.microservices.payment.payment.infrastructure.adapter.out.persistence.PaymentJpaAdapter;
import com.microservices.payment.payment.infrastructure.adapter.out.persistence.mapper.PaymentPersistenceMapper;
import com.microservices.payment.payment.infrastructure.adapter.out.persistence.repository.PaymentJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentBeanConfig {

    @Bean
    public PaymentRepositoryPort paymentRepositoryPort(
            PaymentJpaRepository paymentJpaRepository,
            PaymentPersistenceMapper mapper){
        return new PaymentJpaAdapter(paymentJpaRepository, mapper);
    }

    @Bean
    public AdvanceStatusPaymentPort advanceStatusPaymentPort(PaymentRepositoryPort paymentRepositoryPort){
        return new AdvanceStatusUseCase(paymentRepositoryPort);
    }

    @Bean
    public ExpirePaymentPort expirePaymentPort(PaymentRepositoryPort paymentRepositoryPort){
        return new ExpirePaymentUseCase(paymentRepositoryPort);
    }

    @Bean
    public FailedPaymentPort failedPaymentPort(PaymentRepositoryPort paymentRepositoryPort){
        return new FailedPaymentUseCase(paymentRepositoryPort);
    }

    @Bean
    public FindByIdPaymentPort findByIdPaymentPort(PaymentRepositoryPort paymentRepositoryPort){
        return new FindByIdPaymentUseCase(paymentRepositoryPort);
    }

    @Bean
    public FindPaymentTextPort findPaymentTextPort(PaymentRepositoryPort paymentRepositoryPort){
        return new FindByPaymentTextUseCase(paymentRepositoryPort);
    }


    @Bean
    public ListPaymentPort listPaymentPort(PaymentRepositoryPort paymentRepositoryPort){
        return new ListPaymentUseCase(paymentRepositoryPort);
    }

    @Bean
    public RefundedPaymentPort refundedPaymentPort(PaymentRepositoryPort paymentRepositoryPort){
        return new RefundedPaymentUseCase(paymentRepositoryPort);
    }

    @Bean
    public SavePaymentPort savePaymentPort(PaymentRepositoryPort paymentRepositoryPort){
        return new SavePaymentUseCase(paymentRepositoryPort);
    }
}
