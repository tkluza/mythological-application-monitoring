package com.tkluza.smartcity.payment.business.external.reservation

import com.tkluza.smartcity.payment.business.core.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentRejectedEvent

interface ReservationExternalFacade {

    fun processEvent(event: PaymentConfirmedEvent)

    fun processEvent(event: PaymentRejectedEvent)
}