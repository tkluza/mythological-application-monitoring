package com.tkluza.smartcity.payment.business.external.reservation.http

import com.tkluza.smartcity.payment.business.core.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentRejectedEvent

interface ReservationExternalHttpClient {

    fun sendRequest(event: PaymentConfirmedEvent)

    fun sendRequest(event: PaymentRejectedEvent)
}