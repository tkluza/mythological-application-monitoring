package com.tkluza.smartcity.payment.business.dto.command

import java.util.*

data class CreatePaymentCommand(
    val reservationExternalBusinessKey: UUID
)
