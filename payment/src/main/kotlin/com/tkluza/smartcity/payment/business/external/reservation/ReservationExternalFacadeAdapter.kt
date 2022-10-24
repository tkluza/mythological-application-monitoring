package com.tkluza.smartcity.payment.business.external.reservation

import com.tkluza.smartcity.payment.business.core.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentRejectedEvent
import com.tkluza.smartcity.payment.business.external.reservation.http.ReservationExternalHttpClient
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Transactional
class ReservationExternalFacadeAdapter(
    private val reservationExternalHttpClient: ReservationExternalHttpClient
) : ReservationExternalFacade {

    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    override fun processEvent(event: PaymentConfirmedEvent) {
        reservationExternalHttpClient.sendRequest(event)
    }

    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    override fun processEvent(event: PaymentRejectedEvent) {
        reservationExternalHttpClient.sendRequest(event)
    }
}