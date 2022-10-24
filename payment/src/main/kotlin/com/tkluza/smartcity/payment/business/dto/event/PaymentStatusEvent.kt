package com.tkluza.smartcity.payment.business.dto.event

import java.util.*

interface PaymentStatusEvent {

    val reservationExternalBusinessKey: UUID
}