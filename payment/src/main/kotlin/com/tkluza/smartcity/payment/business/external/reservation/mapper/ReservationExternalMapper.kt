package com.tkluza.smartcity.payment.business.external.reservation.mapper

import com.tkluza.smartcity.payment.business.core.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentRejectedEvent
import com.tkluza.smartcity.payment.business.external.reservation.dto.command.CancelReservationExternalCommand
import com.tkluza.smartcity.payment.business.external.reservation.dto.command.ConfirmReservationExternalCommand

class ReservationExternalMapper {

    fun map(event: PaymentConfirmedEvent): ConfirmReservationExternalCommand =
        with(event) {
            ConfirmReservationExternalCommand(
                reservationExternalBusinessKey = reservationExternalBusinessKey,
                price = price
            )
        }

    fun map(event: PaymentRejectedEvent): CancelReservationExternalCommand =
        with(event) {
            CancelReservationExternalCommand(
                reservationExternalBusinessKey = reservationExternalBusinessKey
            )
        }
}
