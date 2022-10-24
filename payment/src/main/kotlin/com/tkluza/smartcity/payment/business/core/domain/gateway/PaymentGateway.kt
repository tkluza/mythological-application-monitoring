package com.tkluza.smartcity.payment.business.core.domain.gateway

import com.tkluza.smartcity.payment.business.core.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentRejectedEvent

interface PaymentGateway {

    fun publishEvent(event: PaymentConfirmedEvent)

    fun publishEvent(event: PaymentRejectedEvent)
}
