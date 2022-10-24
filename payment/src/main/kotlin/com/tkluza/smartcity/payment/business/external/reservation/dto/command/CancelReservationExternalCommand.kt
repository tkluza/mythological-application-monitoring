package com.tkluza.smartcity.payment.business.external.reservation.dto.command

import java.util.*

data class CancelReservationExternalCommand(
    val reservationExternalBusinessKey: UUID
)
