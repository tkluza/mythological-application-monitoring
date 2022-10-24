package com.tkluza.smartcity.payment.business.core.dto.command

import java.util.*

data class CreatePaymentCommand(
    val reservationExternalBusinessKey: UUID
)
