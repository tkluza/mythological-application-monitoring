package com.tkluza.smartcity.payment.business.core.config

import com.tkluza.smartcity.payment.business.core.domain.PaymentFacade
import com.tkluza.smartcity.payment.business.core.domain.PaymentFacadeAdapter
import com.tkluza.smartcity.payment.business.core.domain.gateway.adapter.PaymentGatewayAdapter
import com.tkluza.smartcity.payment.business.core.domain.mapper.PaymentMapper
import com.tkluza.smartcity.payment.business.core.domain.repository.PaymentRepository
import com.tkluza.smartcity.payment.business.core.domain.service.adapter.PaymentServiceAdapter
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(PaymentConfirmationProperties::class)
class PaymentConfig {

    @Bean
    fun paymentConfirmationProperties(): PaymentConfirmationProperties = PaymentConfirmationProperties()

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