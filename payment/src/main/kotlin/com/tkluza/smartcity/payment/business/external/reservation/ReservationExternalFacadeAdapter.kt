package com.tkluza.smartcity.payment.business.external.reservation

import com.tkluza.smartcity.payment.business.core.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentRejectedEvent
import com.tkluza.smartcity.payment.business.external.reservation.http.ReservationExternalHttpClient
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Transactional
class ReservationExternalFacadeAdapter(
    private val reservationExternalHttpClient: ReservationExternalHttpClient
) : ReservationExternalFacade {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    override fun processEvent(event: PaymentConfirmedEvent) {
        logger.info("Payment for reservation: {} has been confirmed", event.reservationExternalBusinessKey)
        reservationExternalHttpClient.sendRequest(event)
    }

    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    override fun processEvent(event: PaymentRejectedEvent) {
        logger.warn("Payment for reservation: {} has been rejected", event.reservationExternalBusinessKey)
        reservationExternalHttpClient.sendRequest(event)
    }
}