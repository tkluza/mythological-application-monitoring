package com.tkluza.smartcity.payment.business.external.reservation.dto.command

import java.math.BigDecimal
import java.util.*

data class ConfirmReservationExternalCommand(
    val reservationExternalBusinessKey: UUID,
    val price: BigDecimal
)
