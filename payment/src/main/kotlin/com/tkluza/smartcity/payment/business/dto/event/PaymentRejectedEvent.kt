package com.tkluza.smartcity.payment.business.dto.event

import java.util.*

data class PaymentRejectedEvent(
    override val reservationExternalBusinessKey: UUID
) : PaymentStatusEvent
