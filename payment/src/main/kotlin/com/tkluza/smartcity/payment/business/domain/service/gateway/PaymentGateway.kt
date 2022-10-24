package com.tkluza.smartcity.payment.business.domain.service.gateway

import com.tkluza.smartcity.payment.business.dto.event.PaymentStatusEvent

interface PaymentGateway {

    fun publishEvent(event: PaymentStatusEvent)
}
