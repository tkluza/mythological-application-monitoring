package com.tkluza.smartcity.payment.business.dto.event

import java.util.*

data class PaymentConfirmedEvent(
    override val reservationExternalBusinessKey: UUID
) : PaymentStatusEvent
