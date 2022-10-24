package com.tkluza.smartcity.payment.business.core.dto.event

import java.math.BigDecimal
import java.util.*

data class PaymentConfirmedEvent(
    val reservationExternalBusinessKey: UUID,
    val price: BigDecimal
)
