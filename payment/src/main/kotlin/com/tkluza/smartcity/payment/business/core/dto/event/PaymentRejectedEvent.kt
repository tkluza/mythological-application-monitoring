package com.tkluza.smartcity.payment.business.core.dto.event

import java.util.*

data class PaymentRejectedEvent(
    val reservationExternalBusinessKey: UUID
)