package com.tkluza.smartcity.payment.business.config

import com.tkluza.smartcity.payment.business.domain.PaymentFacade
import com.tkluza.smartcity.payment.business.domain.PaymentFacadeAdapter
import com.tkluza.smartcity.payment.business.domain.mapper.PaymentMapper
import com.tkluza.smartcity.payment.business.domain.repository.PaymentRepository
import com.tkluza.smartcity.payment.business.domain.service.adapter.PaymentServiceAdapter
import com.tkluza.smartcity.payment.business.domain.service.gateway.PaymentGatewayAdapter
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PaymentConfig {

    @Bean
    fun paymentFacade(
        applicationEventPublisher: ApplicationEventPublisher,
        paymentConfirmationProperties: PaymentConfirmationProperties,
        paymentRepository: PaymentRepository
    ): PaymentFacade =
        PaymentFacadeAdapter(
            paymentService = PaymentServiceAdapter(
                paymentGateway = PaymentGatewayAdapter(applicationEventPublisher = applicationEventPublisher),
                paymentConfirmationProperties = paymentConfirmationProperties,
                paymentRepository = paymentRepository,
                paymentMapper = PaymentMapper()
            )
        )
}