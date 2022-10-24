package com.tkluza.smartcity.payment.business.domain.service.gateway

import com.tkluza.smartcity.payment.business.dto.event.PaymentStatusEvent
import org.springframework.context.ApplicationEventPublisher

class PaymentGatewayAdapter(
    private val applicationEventPublisher: ApplicationEventPublisher
) : PaymentGateway {

    override fun publishEvent(event: PaymentStatusEvent) {
        applicationEventPublisher.publishEvent(event)
    }
}