package com.tkluza.smartcity.payment.business.domain.mapper

import com.tkluza.smartcity.payment.business.domain.model.PaymentEntity
import com.tkluza.smartcity.payment.business.domain.model.PaymentStatus
import com.tkluza.smartcity.payment.business.dto.command.CreatePaymentCommand
import java.time.LocalDateTime

class PaymentMapper {

    fun map(command: CreatePaymentCommand, status: PaymentStatus): PaymentEntity =
        with(command) {
            PaymentEntity(
                reservationExternalBusinessKey = reservationExternalBusinessKey,
                date = LocalDateTime.now(),
                status = status
            )
        }
}