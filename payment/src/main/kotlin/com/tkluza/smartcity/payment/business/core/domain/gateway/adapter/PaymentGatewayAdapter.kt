package com.tkluza.smartcity.payment.business.core.domain.gateway.adapter

import com.tkluza.smartcity.payment.business.core.domain.gateway.PaymentGateway
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentRejectedEvent
import org.springframework.context.ApplicationEventPublisher

class PaymentGatewayAdapter(
    private val applicationEventPublisher: ApplicationEventPublisher
) : PaymentGateway {

    override fun publishEvent(event: PaymentConfirmedEvent) {
        applicationEventPublisher.publishEvent(event)
    }

    override fun publishEvent(event: PaymentRejectedEvent) {
        applicationEventPublisher.publishEvent(event)
    }
}